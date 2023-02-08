package com.aallam.similarity

import kotlin.math.min

/**
 * The Levenshtein distance between two words is the minimum number of single-character edits (insertions, deletions or
 * substitutions) required to change one string into the other.
 *
 * [Levenshtein Distance](https://en.wikipedia.org/wiki/Levenshtein_distance)
 */
public class Levenshtein {

    /**
     * The Levenshtein distance, or edit distance, between two words is the minimum number of single-character edits
     * (insertions, deletions or substitutions) required to change one word into the other.
     *
     * It is always at least the difference of the sizes of the two strings.
     * It is at most the length of the longer string.
     * It is `0` if and only if the strings are equal.
     *
     * @param lhs left hand side string to compare.
     * @param rhs right hand side string to compare.
     * @param limit the maximum result to compute before stopping, terminating calculation early.
     * @return the computed Levenshtein distance.
     */
    public fun distance(lhs: CharSequence, rhs: CharSequence, limit: Int = Int.MAX_VALUE): Int {
        if (lhs == rhs) return 0
        if (lhs.isEmpty()) return rhs.length
        if (rhs.isEmpty()) return lhs.length

        // initial costs is the edit distance from an empty string, which corresponds to the characters to delete.
        // the array size is : length + 1 (empty string)
        var cost = IntArray(lhs.length + 1) { it }
        var newCost = IntArray(lhs.length + 1)

        for (i in 1..rhs.length) {

            // calculate new costs from the previous row.
            // the first element of the new row is the edit distance (deletes) to match empty string
            newCost[0] = i

            var minCost = i

            // fill in the rest of the row
            for (j in 1..lhs.length) {
                // if it's the same char at the same position, no edit cost.
                val edit = if (lhs[j - 1] == rhs[i - 1]) 0 else 1
                val replace = cost[j - 1] + edit
                val insert = cost[j] + 1
                val delete = newCost[j - 1] + 1
                newCost[j] = minOf(insert, delete, replace)
                minCost = min(minCost, newCost[j])
            }

            if (minCost >= limit) return limit

            // flip references of current and previous row
            val swap = cost
            cost = newCost
            newCost = swap
        }

        return cost.last()
    }
}
