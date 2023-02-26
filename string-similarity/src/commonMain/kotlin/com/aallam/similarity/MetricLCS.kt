package com.aallam.similarity

import kotlin.math.max

/**
 * Distance metric based on Longest Common Subsequence.
 */
public class MetricLCS {

    private val lcs = LongestCommonSubsequence()

    /**
     * Distance metric based on Longest Common Subsequence, computed as
     * `1 - |LCS(first, second)| / max(|first|, |second|)`.
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     */
    public fun distance(first: String, second: String): Double {
        if (first == second) return 0.0
        val m = max(first.length, second.length)
        if (m == 0) return 0.0
        return 1.0 - lcs.length(first, second) / m.toDouble()
    }
}
