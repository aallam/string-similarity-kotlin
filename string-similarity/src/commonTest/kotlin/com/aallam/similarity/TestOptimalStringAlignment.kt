package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestOptimalStringAlignment {

    @Test
    fun distance() {
        val osa = OptimalStringAlignment()

        //equality
        assertEquals(0, osa.distance("ABDCEF", "ABDCEF"))

        //single operation
        assertEquals(1, osa.distance("ABDCFE", "ABDCEF"))
        assertEquals(1, osa.distance("BBDCEF", "ABDCEF"))
        assertEquals(1, osa.distance("BDCEF", "ABDCEF"))
        assertEquals(1, osa.distance("ABDCEF", "ADCEF"))

        //other
        assertEquals(3, osa.distance("CA", "ABC"))
        assertEquals(2, osa.distance("BAC", "CAB"))
        assertEquals(4, osa.distance("abcde", "awxyz"))
        assertEquals(5, osa.distance("abcde", "vwxyz"))
    }
}
