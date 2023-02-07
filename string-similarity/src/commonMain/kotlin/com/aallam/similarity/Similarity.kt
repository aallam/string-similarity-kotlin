package com.aallam.similarity

public interface Similarity {

    /**
     * Compute and return a measure of similarity between 2 strings.
     *
     * @param s1 first string
     * @param s2 second string
     * @return similarity (0 means both strings are completely different)
     */
    public fun similarity(s1: String, s2: String): Double
}
