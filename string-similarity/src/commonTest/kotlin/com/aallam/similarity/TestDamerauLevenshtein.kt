package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestDamerauLevenshtein {

    @Test
    fun distance() {
        val damerau = DamerauLevenshtein()
        assertEquals(1, damerau.distance("ABCDEF", "ABDCEF"))
        assertEquals(2, damerau.distance("ABCDEF", "BACDFE"))
        assertEquals(1, damerau.distance("ABCDEF", "ABCDE"))
    }
}