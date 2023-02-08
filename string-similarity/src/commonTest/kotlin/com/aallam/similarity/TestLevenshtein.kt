package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestLevenshtein {

    @Test
    fun distance() {
        val levenshtein = Levenshtein()
        assertEquals(1, levenshtein.distance("My string", "My tring"))
        assertEquals(0, levenshtein.distance("My string", "My string"))
        assertEquals(2, levenshtein.distance("", "My"))
        assertEquals(2, levenshtein.distance("My", ""))
        assertEquals(2, levenshtein.distance("My string", "M string2"))
        assertEquals(1, levenshtein.distance("My string", "My \$tring"))
        assertEquals(2, levenshtein.distance("My string", "M string2", 4))
        assertEquals(2, levenshtein.distance("My string", "M string2", 2))
        assertEquals(1, levenshtein.distance("My string", "M string2", 1))
    }
}