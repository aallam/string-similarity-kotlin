package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestLevenshteinNormalized {

    @Test
    fun normalized() {
        val levenshtein = LevenshteinNormalized()
        assertEquals(0.11, levenshtein.distance("My string", "My tring"), 0.01)
        assertEquals(0.22, levenshtein.distance("My string", "M string2"), 0.01)
        assertEquals(0.11, levenshtein.distance("My string", "My \$tring"), 0.01)
        assertEquals(0.0, levenshtein.distance("My string", "My string"), 0.01)
        assertEquals(1.0, levenshtein.distance("", "My"))
        assertEquals(1.0, levenshtein.distance("My", ""))
    }

    @Test
    fun similarity() {
        val levenshtein = LevenshteinNormalized()
        assertEquals(0.89, levenshtein.similarity("My string", "My tring"), 0.01)
        assertEquals(0.78, levenshtein.similarity("My string", "M string2"), 0.01)
        assertEquals(0.89, levenshtein.similarity("My string", "My \$tring"), 0.01)
        assertEquals(1.0, levenshtein.similarity("My string", "My string"), 0.01)
        assertEquals(0.0, levenshtein.similarity("", "My"))
        assertEquals(0.0, levenshtein.similarity("My", ""))
    }
}