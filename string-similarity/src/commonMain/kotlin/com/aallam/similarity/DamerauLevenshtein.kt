package com.aallam.similarity

/**
 * Damerau-Levenshtein distance with transposition (*unrestricted Damerau-Levenshtein* distance).
 *
 * The distance is the minimum number of operations needed to transform one string into the other, where an operation
 * is defined as an insertion, deletion, or substitution of a single character, or a transposition of two adjacent
 * characters. It does respect triangle inequality, and is thus a metric distance.
 *
 * [Damerau–Levenshtein](https://en.wikipedia.org/wiki/Damerau%E2%80%93Levenshtein_distance#Distance_with_adjacent_transpositions)
 */
public class DamerauLevenshtein {

    /**
     * Compute the distance between strings: the minimum number of operations needed to transform one string into the
     * other (insertion, deletion, substitution of a single character, or a transposition of two adjacent characters).
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     */
    public fun distance(first: CharSequence, second: CharSequence): Int {

        // Infinite distance is the max possible distance
        val infinity = first.length + second.length

        // Create and initialize the character array indices
        val charsRowIndex = mutableMapOf<Char, Int>()
        for (index in first.indices) charsRowIndex[first[index]] = 0
        for (char in second) charsRowIndex[char] = 0

        // Create the distance matrix H[0 .. first.length+1][0 .. second.length+1]
        val distanceMatrix = Array(first.length + 2) { IntArray(second.length + 2) }

        // initialize the left edge
        for (i in first.indices) {
            distanceMatrix[i + 1][0] = infinity
            distanceMatrix[i + 1][1] = i
        }

        // initialize top edge
        for (j in second.indices) {
            distanceMatrix[0][j + 1] = infinity
            distanceMatrix[1][j + 1] = j
        }

        // fill in the distance matrix
        for (i in 1..first.length) {
            var lastMatch = 0

            for (j in 1..second.length) {
                val lastRowIndex = charsRowIndex.getValue(second[j - 1])
                val previousMatch = lastMatch
                val cost: Int
                if (first[i - 1] == second[j - 1]) {
                    cost = 0
                    lastMatch = j
                } else {
                    cost = 1
                }

                val substitution = distanceMatrix[i][j] + cost
                val insertion = distanceMatrix[i + 1][j] + 1
                val deletion = distanceMatrix[i][j + 1] + 1
                val transposition = distanceMatrix[lastRowIndex][previousMatch] + (i - lastRowIndex - 1) + 1 + (j - previousMatch - 1)
                distanceMatrix[i + 1][j + 1] = minOf(substitution, insertion, deletion, transposition)
            }
            charsRowIndex[first[i - 1]] = i
        }

        return distanceMatrix[first.length + 1][second.length + 1]
    }
}
