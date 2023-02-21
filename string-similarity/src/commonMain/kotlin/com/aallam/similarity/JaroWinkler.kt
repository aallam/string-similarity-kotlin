package com.aallam.similarity

import kotlin.math.max
import kotlin.math.min

/**
 * The Jaro–Winkler distance metric is designed and best suited for short strings such as person names, and to detect
 * typos; it is (roughly) a variation of Damerau-Levenshtein, where the substitution of 2 close characters is considered
 * less important than the substitution of 2 characters that a far from each other.
 *
 * Jaro-Winkler was developed in the area of record linkage (duplicate detection) (Winkler, 1990).
 * It returns a value in the interval [0.0, 1.0].
 *
 * @param threshold The current value of the threshold used for adding the Winkler bonus. The default value is 0.7.
 *
 * [Jaro–Winkler distance](https://en.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance)
 */
public class JaroWinkler(
    private val threshold: Double = 0.7
) {

    /**
     * Compute Jaro-Winkler similarity.
     *
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     * @return The Jaro-Winkler similarity in the range [0, 1]
     */
    public fun similarity(first: String, second: String): Double {
        if (first == second) return 1.0
        val (m, t, l, p) = matchStrings(first, second)
        if (m == 0f) return 0.0
        // Jaro similarity = 1/3 * (m/|s1| + m/|s2| + (m-t)/m)
        val sj = ((m / first.length) + (m / second.length) + ((m - t) / m)) / 3.0
        // Winkler similarity = Sj + P * L * (1 – Sj)
        return if (sj > threshold) sj + p * l * (1 - sj) else sj
    }

    /**
     * Return 1 - similarity.
     * @param first the first string to compare.
     * @param second the second string to compare.
     * @return 1 - similarity.
     */
    public fun distance(first: String, second: String): Double {
        return 1.0 - similarity(first, second)
    }

    /**
     * Matches two given strings and returns the count of matching characters, transpositions, the length of the
     * common prefix, and the scaling factor.
     *
     * @param first The first string to compare.
     * @param second The second string to compare.
     */
    private fun matchStrings(first: String, second: String): Match {
        val min = minOf(first, second)
        val max = maxOf(first, second)
        val (matchIndexes, matchFlags, matches) = computeStringMatch(max, min)
        val ms1 = CharArray(matches).apply { fill(min, matchIndexes) }
        val ms2 = CharArray(matches).apply { fill(max, matchFlags) }
        val transpositions = transpositions(ms1, ms2)
        val prefix = commonPrefix(min, max)
        val scaling = min(JW_SCALING_FACTOR, 1.0 / max.length)
        return Match(matches.toFloat(), transpositions, prefix, scaling)
    }

    /**
     * Computes the matching indexes and flags between two strings.
     *
     * @param max the longer string
     * @param min the shorter string
     */
    private fun computeStringMatch(max: String, min: String): StringMatchInfo {
        val range = max(max.length / 2 - 1, 0)
        val matchIndexes = IntArray(min.length) { -1 }
        val matchFlags = BooleanArray(max.length)
        var matches = 0
        for (i in min.indices) {
            val char = min[i]
            var xi = max(i - range, 0)
            val xn = min(i + range + 1, max.length)
            while (xi < xn) {
                if (!matchFlags[xi] && char == max[xi]) {
                    matchIndexes[i] = xi
                    matchFlags[xi] = true
                    matches++
                    break
                }
                xi++
            }
        }
        return StringMatchInfo(matchIndexes, matchFlags, matches)
    }

    /**
     * Fills this character array with the characters from [max] at the positions indicated by the corresponding value
     * in [flags].
     *
     * @param max the string from which to take the characters.
     * @param flags the boolean array indicating which characters in the max string should be included.
     */
    private fun CharArray.fill(max: String, flags: BooleanArray) {
        var si = 0
        for (i in max.indices) {
            if (flags[i]) {
                this[si] = max[i]
                si++
            }
        }
    }

    /**
     * Fills the character array with characters from the given string [min], based on the specified match [indexes].
     *
     * @param min the string containing the characters to be copied into the character array.
     * @param indexes the indexes indicating which characters to copy from `min`. Any index value of -1 will be ignored.
     */
    private fun CharArray.fill(min: String, indexes: IntArray) {
        var si = 0
        for (i in min.indices) {
            if (indexes[i] != -1) {
                this[si] = min[i]
                si++
            }
        }
    }


    /**
     * Calculates the length of the common prefix between two strings.
     *
     * @param min the shorter of the two strings being compared
     * @param max the longer of the two strings being compared
     */
    private fun commonPrefix(min: String, max: String): Int {
        var prefix = 0
        for (mi in min.indices) {
            if (min[mi] != max[mi]) break
            prefix++
        }
        return prefix
    }

    /**
     * Calculates the number of transpositions between two matched strings.
     *
     * @param ms1 the first matched string.
     * @param ms2 the second matched string.
     */
    private fun transpositions(ms1: CharArray, ms2: CharArray): Int {
        var transpositions = 0
        for (mi in ms1.indices) {
            if (ms1[mi] != ms2[mi]) {
                transpositions++
            }
        }
        return transpositions / 2
    }

    public companion object {

        /** The standard value for the scaling factor */
        private const val JW_SCALING_FACTOR = 0.1
    }
}

/**
 * Represents information about the matching indexes and flags between two strings,
 * along with the total number of matches found.
 *
 * @param matchIndexes matching indexes
 * @param matchFlags matching flags
 * @param matches total number of matches found
 */
internal data class StringMatchInfo(
    val matchIndexes: IntArray,
    val matchFlags: BooleanArray,
    val matches: Int
)

/**
 * Represents a set of parameters that describe the similarity between two strings.
 *
 * @param matches number of matching characters
 * @param transpositions number of transpositions
 * @param prefix length of common prefix
 * @param scaling scaling factor
 */
internal data class Match(
    val matches: Float,
    val transpositions: Int,
    val prefix: Int,
    val scaling: Double,
)
