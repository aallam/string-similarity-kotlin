package com.aallam.similarity

public interface Distance {

    /**
     * Compute and return a measure of distance.
     *
     * @param s1 the first string
     * @param s2 the second string
     * @return distance (must be >= 0)
     */
    public fun distance(s1: String, s2: String): Double
}
