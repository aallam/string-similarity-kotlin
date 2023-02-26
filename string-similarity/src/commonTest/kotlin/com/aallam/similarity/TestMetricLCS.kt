package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestMetricLCS {

    @Test
    fun testDistance() {
        val lcs = MetricLCS()
        assertEquals(0.4, lcs.distance("ABCDEFG", "ABCDEFHJKL"), 0.01)
        assertEquals(0.2, lcs.distance("ABDEF", "ABDIF"), 0.01)
    }
}
