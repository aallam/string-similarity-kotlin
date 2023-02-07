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
 * @param k length of k-shingles
 */
public class Cosine(private val k: Int = 3) : Shingle, Similarity, Distance {

    /**
     * Compute the cosine similarity between strings.
     *
     * It is computed as `V1.V2/(|V1|*|V2|)` where `V1` and `V2` are vector representation of [s1] and [s2].
     *
     * @param s1 the first string to compare.
     * @param s2 the second string to compare.
     * @return the cosine similarity in the range `[0, 1]`.
     */
    override fun similarity(s1: String, s2: String): Double {
        if (s1 == s2) return 1.0
        if (s1.length < k || s2.length < k) return 0.0
        val p1 = profile(s1, k)
        val p2 = profile(s2, k)
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

    override fun distance(s1: String, s2: String): Double {
        return 1.0 - similarity(s1, s2)
    }
}
