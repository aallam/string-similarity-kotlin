package com.aallam.similarity

import com.aallam.similarity.internal.Shingle
import kotlin.test.Test
import kotlin.test.assertEquals

class TestShingle {

    @Test
    fun test() {
        val profile = Shingle.profile("JOHN  JOHANN", 3)
        val expected = mapOf(
            ("JOH" to 2),
            ("OHN" to 1),
            ("HN " to 1),
            ("N J" to 1),
            (" JO" to 1),
            ("OHA" to 1),
            ("HAN" to 1),
            ("ANN" to 1),
        )
        assertEquals(expected, profile)
    }
}
