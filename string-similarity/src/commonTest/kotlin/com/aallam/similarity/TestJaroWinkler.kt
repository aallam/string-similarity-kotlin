package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestJaroWinkler {
    /**
     * Test of similarity method, of class JaroWinkler.
     */
    @Test
    fun testSimilarity() {
        val jaroWinkler = JaroWinkler()
        assertEquals(0.974074, jaroWinkler.similarity("My string", "My tsring"), 0.000001)
        assertEquals(0.896296, jaroWinkler.similarity("My string", "My ntrisg"), 0.000001)
    }
}
