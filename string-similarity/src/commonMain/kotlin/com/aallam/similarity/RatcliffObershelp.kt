package com.aallam.similarity

/**
 * The Ratcliff/Obershelp algorithm computes the similarity of two strings the doubled number of matching characters
 * divided by the total number of characters in the two strings. Matching characters are those in the longest common
 * subsequence plus, recursively, matching characters in the unmatched region on either side of the longest common
 * subsequence.
 */
public class RatcliffObershelp {

    /**
     * Compute the Ratcliff-Obershelp similarity between strings.
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     */
    public fun similarity(first: String, second: String): Double {
        if (first == second) return 1.0
        val matches = matchList(first, second)
        val sumOfMatches = matches.sumOf { it.length }
        return 2.0 * sumOfMatches / (first.length + second.length)
    }

    /**
     * Return 1 - similarity.
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     */
    public fun distance(first: String, second: String): Double {
        return 1.0 - similarity(first, second)
    }

    /**
     * Returns a list of matching substrings between the given [first] and [second] strings.
     *
     * @param first The first string to compare.
     * @param second The second string to compare.
     */
    private fun matchList(first: String, second: String): List<String> {
        val match = frontMaxMatch(first, second)
        if (match.isEmpty()) return emptyList()
        val frontQueue = matchList(first.substringBefore(match), second.substringBefore(match))
        val endQueue = matchList(first.substringAfter(match), second.substringAfter(match))
        return listOf(match) + frontQueue + endQueue
    }

    /**
     * Returns the longest substring that occurs at the beginning of both the [first] and [second] strings.
     *
     * @param first the first string to compare.
     * @param second the second string to compare.
     */
    private fun frontMaxMatch(first: String, second: String): String {
        var longestSubstring = ""
        for (i in first.indices) {
            for (j in i + 1..first.length) {
                val substring = first.substring(i, j)
                if (second.contains(substring) && substring.length > longestSubstring.length) {
                    longestSubstring = substring
                }
            }
        }
        return longestSubstring
    }
}
