package com.aallam.similarity

import com.aallam.similarity.internal.Shingle

/**
 * Sorensen-Dice coefficient, aka Sørensen index, Dice's coefficient or Czekanowski's binary (non-quantitative) index.
 *
 * The strings are first converted to boolean sets of k-shingles (sequences of k characters), then the similarity is
 * computed as 2 * |A inter B| / (|A| + |B|).
 *
 * Attention: Sorensen-Dice distance (and similarity) does not satisfy triangle inequality.
 *
 * [Sørensen–Dice coefficient](https://en.wikipedia.org/wiki/S%C3%B8rensen%E2%80%93Dice_coefficient)
 *
 * @param k length of k-shingles
 */
public class SorensenDice(public val k: Int = 3) {


    /**
     * Similarity is computed as 2 * |A ∩ B| / (|A| + |B|).
     *
     * @param first The first string to compare.
     * @param second The second string to compare.
     */
    public fun similarity(first: String, second: String): Double {
        if (first == second) return 1.0
        val profile1 = Shingle.profile(first, k)
        val profile2 = Shingle.profile(second, k)
        val intersect = profile1.keys.intersect(profile2.keys)
        return (2.0 * intersect.size) / (profile1.size + profile2.size)
    }

    /**
     * Returns 1 - similarity.
     *
     * @param first The first string to compare.
     * @param second The second string to compare.
     */
    public fun distance(first: String, second: String): Double {
        return 1.0 - similarity(first, second)
    }
}