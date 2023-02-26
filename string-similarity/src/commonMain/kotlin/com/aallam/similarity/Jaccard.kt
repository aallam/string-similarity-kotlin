package com.aallam.similarity

import com.aallam.similarity.internal.Shingle

/**
 * Each input string is converted into a set of n-grams, the Jaccard index is then computed as `|A ∩ B| / |A ∪ B|`.
 *
 * Like Q-Gram distance, the input strings are first converted into sets of n-grams (sequences of n characters, also
 * called k-shingles), but this time the cardinality of each n-gram is not taken into account.
 *
 * Jaccard index is a metric distance.
 *
 * @param k length of k-shingles
 */
public class Jaccard(private val k: Int = 3) {

    /**
     * Compute Jaccard index. `|A ∩ B| / |A ∪ B|`.
     * @param first the first string to compare.
     * @param second the second string to compare.
     */
    public fun similarity(first: String, second: String): Double {
        if (first == second) return 1.0
        val p1 = Shingle.profile(first, k)
        val p2 = Shingle.profile(second, k)
        val union = p1.keys + p2.keys
        val inter = p1.keys.size + p2.keys.size - union.size
        return inter.toDouble() / union.size
    }

    /**
     * Distance is computed as 1 - similarity.
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     */
    public fun distance(first: String, second: String): Double {
        return 1.0 - similarity(first, second)
    }
}
