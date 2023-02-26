package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestNGram {

    @Test
    fun testDistance() {
        val s0 = "ABABABAB"
        val s1 = "ABCABCABCABC"
        val s2 = "POIULKJH"
        val ngram = NGram()
        assertTrue(ngram.distance(s0, s1) < ngram.distance(s0, s2))
        assertEquals(0.0, ngram.distance("SIJK", "SIJK"))
        assertEquals(0.0, ngram.distance("S", "S"))
        assertEquals(1.0, ngram.distance("", "S"))
        assertEquals(1.0, ngram.distance("", "SIJK"))
    }
}
