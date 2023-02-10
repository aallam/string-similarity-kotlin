package com.aallam.similarity

import kotlin.math.max

/**
 * This distance is computed as levenshtein distance divided by the length of the longest string.
 * The resulting value is always in the interval 0 to 1.
 *
 * [Levenshtein Distance](https://en.wikipedia.org/wiki/Levenshtein_distance)
 */
public class NormalizedLevenshtein {

    /**
     * Levenshtein distance metric implementation.
     */
    private val levenshtein = Levenshtein()

    /**
     * This distance is computed as levenshtein distance divided by the length of the longest string.
     * The resulting value is always in the interval 0 to 1.
     *
     *  Compute distance as Levenshtein(s1, s2) / max(|s1|, |s2|).
     *
     * @param first left hand side string to compare.
     * @param second right hand side string to compare.
     * @return the computed normalized Levenshtein distance.
     */
    public fun distance(first: CharSequence, second: CharSequence): Double {
        val maxLength = max(first.length, second.length)
        if (maxLength == 0) return 0.0
        return levenshtein.distance(first, second) / maxLength.toDouble()
    }

    /**
     * Compute the similarity between two string.
     * Corresponds to 1.0 - normalized distance.
     *
     * @param lhs left hand side string to compare.
     * @param rhs right hand side string to compare.
     * @return the computer similarity
     */
    public fun similarity(lhs: CharSequence, rhs: CharSequence): Double {
        return 1.0 - distance(lhs, rhs)
    }
}
