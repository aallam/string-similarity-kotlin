package com.aallam.similarity

import kotlin.math.max

/**
 * The longest common subsequence (LCS) problem consists in finding the longest subsequence common to two (or more)
 * sequences. It differs from problems of finding common substrings: unlike substrings, subsequences are not required
 * to occupy consecutive positions within the original sequences.
 *
 * LCS distance is equivalent to Levenshtein distance, when only insertion and deletion is allowed (no substitution),
 * or when the cost of the substitution is the double of the cost of an insertion or deletion.
 */
public class LongestCommonSubsequence {

    /**
     * Return the LCS distance between strings [first] (length n) and [second] (length m),
     * computed as `|n| + |m| - 2 * |LCS(first, second)|`, with min = 0 max = n + m
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     */
    public fun distance(first: String, second: String): Int {
        if (first == second) return 0
        return first.length + second.length - 2 * length(first, second)
    }

    /**
     * Return the length of the longest common subsequence (LCS) between strings [first]
     * and [second].
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     */
    public fun length(first: String, second: String): Int {
        val n = first.length
        val m = second.length
        val x = first.toCharArray()
        val y = second.toCharArray()
        val c = Array(n + 1) { IntArray(m + 1) }
        for (i in 1..n) {
            for (j in 1..m) {
                if (x[i - 1] == y[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1
                } else {
                    c[i][j] = max(c[i][j - 1], c[i - 1][j])
                }
            }
        }
        return c[n][m]
    }
}
