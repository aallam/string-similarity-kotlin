package com.aallam.similarity.internal

/**
 * Similarities that rely on set operations (like cosine similarity or jaccard index).
 */
internal interface Shingle {

    /**
     * Compute and return the profile of string as defined by [Ukkonen](https://www.cs.helsinki.fi/u/ukkonen/TCS92.pdf).
     *
     * The profile is the number of occurrences of k-shingles, and is used to compute q-gram similarity, Jaccard index,
     * etc.
     *
     * k-shingling is the operation of transforming a string (or text document) into a set of n-grams, which can be used to
     * measure the similarity between two strings or documents.
     *
     * Generally speaking, a k-gram is any sequence of [k] tokens.
     * Multiple subsequent spaces are replaced by a single space, and a k-gram is a sequence of k characters.
     *
     * Default value of [k] is `3`. A good rule of thumb is to imagine that there are only 20 characters and estimate the
     * number of k-shingles as 20^k. For small documents like e-mails, k = 5 is a recommended value. For large documents,
     * such as research articles, k = 9 is considered a safe choice.
     *
     * The memory requirement of the profile can be up to [k] * [string]`.length`.
     *
     * @param string input string
     * @param k length of k-shingles
     * @return the profile of the provided string
     */
    fun profile(string: CharSequence, k: Int = 3): Profile {
        require(k > 0) { "k should be positive" }
        val filtered = spaces.replace(string, " ")
        return filtered.windowed(size = k).groupingBy { it }.eachCount()
    }

    companion object : Shingle {

        /**
         * Regex for subsequent spaces.
         */
        private val spaces = Regex("\\s+")
    }
}

/**
 * The number of occurrences of k-shingles.
 */
internal typealias Profile = Map<String, Int>
