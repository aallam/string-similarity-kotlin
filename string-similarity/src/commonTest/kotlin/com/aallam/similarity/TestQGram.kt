package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestQGram {

    @Test
    fun distance() {
        val qGram = QGram(2)
        assertEquals(2, qGram.distance("ABCD", "ABCE"))
        assertEquals(0, qGram.distance("S", "S"))
        assertEquals(0, qGram.distance("012345", "012345"))
        assertEquals(0, qGram.distance("", ""))
        assertEquals(2, qGram.distance("", "foo"))
        assertEquals(2, qGram.distance("foo", ""))
    }
}
