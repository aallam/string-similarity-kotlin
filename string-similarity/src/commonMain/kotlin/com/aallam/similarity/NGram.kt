package com.aallam.similarity

import kotlin.math.max
import kotlin.math.min


/**
 * N-Gram Similarity as defined by Kondrak, "N-Gram Similarity and Distance", String Processing and Information
 * Retrieval, Lecture Notes in Computer Science Volume 3772, 2005, pp 115-126.
 *
 * The algorithm uses affixing with special character '\n' to increase the weight of first characters.
 * The normalization is achieved by dividing the total similarity score the original length of the longest word.
 *
 * [N-Gram Similarity and Distance](http://webdocs.cs.ualberta.ca/~kondrak/papers/spire05.pdf)
 *
 * @param n n-gram length.
 */
public class NGram(private val n: Int = 2) {

    /**
     * Compute n-gram distance, in the range `[0, 1]`.
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     */
    public fun distance(first: String, second: String): Double {
        if (first == second) return 0.0
        val sl = first.length
        val tl = second.length
        if (sl == 0 || tl == 0) return 1.0

        val special = '\n'
        var cost = 0
        if (sl < n || tl < n) {
            val ni = min(sl, tl)
            for (i in 0..ni) {
                if (first[i] == second[i]) cost++
            }
            return cost.toDouble() / max(sl, tl)
        }

        // construct `sa` with prefix
        val sa = CharArray(sl + n - 1) { i ->
            if (i < n - 1) special else first[i - n + 1]
        }

        var p = DoubleArray(sl + 1) { it.toDouble() } // 'previous' cost array, horizontally
        var d = DoubleArray(sl + 1) // cost array, horizontally
        var tj = CharArray(n) // jth n-gram of t
        for (j in 1..tl) {
            // construct tj n-gram
            if (j < n) {
                for (ti in 0..<n - j) {
                    tj[ti] = special // add prefix
                }
                for (ti in n - j..<n) {
                    tj[ti] = second[ti - (n - j)]
                }
            } else {
                tj = second.substring(j - n, j).toCharArray()
            }
            d[0] = j.toDouble()

            for (i in 1..sl) {
                cost = 0
                var tn = n
                // compare sa to tj
                for (ni in 0..<n) {
                    if (sa[i - 1 + ni] != tj[ni]) {
                        cost++
                    } else if (sa[i - 1 + ni] == special) {
                        tn-- // discount matches on prefix
                    }
                }
                val ec = cost.toDouble() / tn
                // minimum of cell to the left+1, to the top+1,
                // diagonally left and up +cost
                d[i] = minOf(d[i - 1] + 1, p[i] + 1, p[i - 1] + ec)
            }
            // copy current distance counts to 'previous row' distance counts
            val swap = p
            p = d
            d = swap
        }

        // our last action in the above loop was to switch d and p, so p now
        // actually has the most recent cost counts
        return p[sl] / max(tl, sl)
    }
}
