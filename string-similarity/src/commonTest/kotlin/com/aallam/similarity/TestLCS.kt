package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestLCS {

    @Test
    fun testDistance() {
        println("distance")
        val lcs = LongestCommonSubsequence()
        // LCS = GA or GC => distance = 4 (remove 3 letters and add 1)
        assertEquals(4, lcs.distance("AGCAT", "GAC"))
        assertEquals(1, lcs.distance("AGCAT", "AGCT"))
    }
}
