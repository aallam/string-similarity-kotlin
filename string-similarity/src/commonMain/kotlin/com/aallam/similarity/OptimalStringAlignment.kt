package com.aallam.similarity

import kotlin.math.min

/**
 * Implementation of the Optimal String Alignment (sometimes called the restricted edit distance) variant
 * of the Damerau-Levenshtein distance.
 *
 * The difference between the two algorithms consists in that the Optimal String Alignment algorithm computes the number
 * of edit operations needed to make the strings equal under the condition that no substring is edited more than once,
 * whereas Damerau-Levenshtein presents no such restriction.
 */
public class OptimalStringAlignment {

    /**
     * Compute the distance between strings: the minimum number of operations needed to transform one string into the
     * other (insertion, deletion, substitution of a single character, or a transposition of two adjacent characters)
     * while no substring is edited more than once.
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     */
    public fun distance(first: String, second: String): Int {
        if (first == second) return 0
        val n = first.length
        val m = second.length
        if (n == 0) return m
        if (m == 0) return n

        // create the distance matrix H[0..first.length+1][0..second.length+1]
        val distanceMatrix = Array(n + 2) { IntArray(m + 2) }

        // initialize top row and leftmost column
        for (i in 0..n) distanceMatrix[i][0] = i
        for (j in 0..m) distanceMatrix[0][j] = j

        // fill the distance matrix
        for (i in 1..n) {
            for (j in 1..m) {
                val cost = if (first[i - 1] == second[j - 1]) 0 else 1
                val substitution = distanceMatrix[i - 1][j - 1] + cost
                val insertion = distanceMatrix[i][j - 1] + 1
                val deletion = distanceMatrix[i - 1][j] + 1
                distanceMatrix[i][j] = minOf(substitution, insertion, deletion)

                // transposition check
                if (i > 1 && j > 1 && first[i - 1] == second[j - 2] && first[i - 2] == second[j - 1]) {
                    distanceMatrix[i][j] = min(distanceMatrix[i][j], distanceMatrix[i - 2][j - 2] + cost)
                }
            }
        }

        return distanceMatrix[n][m]
    }
}
