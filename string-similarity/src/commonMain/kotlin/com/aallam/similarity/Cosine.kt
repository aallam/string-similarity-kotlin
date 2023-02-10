package com.aallam.similarity

import com.aallam.similarity.internal.Profile
import com.aallam.similarity.internal.Shingle
import kotlin.math.sqrt

/**
 * Implements Cosine Similarity between strings.
 *
 * The strings are first transformed in vectors of occurrences of k-shingles (sequences of [k] characters).
 * In this n-dimensional space, the similarity between the two strings is the cosine of their respective vectors.
 *
 * The cosine distance is computed as `1 - cosine similarity`.
 *
 * [Cosine Similarity](https://en.wikipedia.org/wiki/Cosine_similarity)
 *
 * @param k length of k-shingles
 */
public class Cosine(private val k: Int = 3) {

    /**
     * Compute the cosine similarity between strings.
     *
     * It is computed as `V1.V2/(|V1|*|V2|)` where `V1` and `V2` are vector representation of [first] and [second].
     *
     * @param first first string to compare.
     * @param second second string to compare.
     * @return the cosine similarity in the range `[0, 1]`.
     */
    public fun similarity(first: CharSequence, second: CharSequence): Double {
        if (first == second) return 1.0
        if (first.length < k || second.length < k) return 0.0
        val p1 = Shingle.profile(first, k)
        val p2 = Shingle.profile(second, k)
        return (p1 dot p2) / (norm(p1) * norm(p2))
    }

    /** Dot product */
    private infix fun Profile.dot(profile: Profile): Int {
        val intersection = keys.intersect(profile.keys)
        return intersection.sumOf { getValue(it) * profile.getValue(it) }
    }

    /** Compute the norm L2 : sqrt(sum(v²)). */
    private fun norm(profile: Profile): Double {
        val sum = profile.values.sumOf { it * it }.toDouble()
        return sqrt(sum)
    }

    /**
     * Compute the cosine distance between two string.
     * Corresponds to 1.0 - similarity.
     *
     * @param first first string to compare.
     * @param second second string to compare.
     */
    public fun distance(first: CharSequence, second: CharSequence): Double {
        return 1.0 - similarity(first, second)
    }
}
