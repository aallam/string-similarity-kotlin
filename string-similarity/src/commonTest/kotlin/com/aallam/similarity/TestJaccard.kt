package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestJaccard {

    @Test
    fun distance() {
        val jaccard = Jaccard(2)
        assertEquals(0.4, jaccard.distance("ABCDE", "ABCDF"))
    }

    @Test
    fun similarity() {
        val jaccard = Jaccard(2)
        val result = jaccard.similarity("ABCDE", "ABCDF")
        assertEquals(0.6, result)
    }
}
