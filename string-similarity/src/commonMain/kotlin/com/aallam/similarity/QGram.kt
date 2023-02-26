package com.aallam.similarity

import com.aallam.similarity.internal.Profile
import com.aallam.similarity.internal.Shingle
import kotlin.math.abs

/**
 * Q-gram distance, as defined by Ukkonen in [Approximate string-matching with q-grams and maximal matches](http://www.sciencedirect.com/science/article/pii/0304397592901434).
 * The distance between two strings is defined as the L1 norm of the difference of their profiles (the number
 * of occurrences of each n-gram).
 *
 * Q-gram distance is a lower bound on Levenshtein distance, but can be computed in O(m+n), where Levenshtein
 * requires O(m.n).
 *
 * @param k length of k-shingles
 */
public class QGram(private val k: Int = 3) {

    /**
     * The distance between two strings is defined as the L1 norm of the
     * difference of their profiles (the number of occurence of each k-shingle).
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     * @return The computed Q-gram distance.
     * @throws NullPointerException if s1 or s2 is null.
     */
    public fun distance(first: String, second: String): Int {
        if (first == second) return 0
        val p1 = Shingle.profile(first, k)
        val p2 = Shingle.profile(second, k)
        return distance(p1, p2)
    }

    /**
     * Compute QGram distance using precomputed profiles.
     */
    private fun distance(first: Profile, second: Profile): Int {
        var agg = 0
        for (key in (first.keys + second.keys)) {
            var v1 = 0
            var v2 = 0
            first[key]?.let { v1 = it }
            second[key]?.let { v2 = it }
            agg += abs(v1 - v2)
        }
        return agg
    }
}
