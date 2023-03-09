package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestSorensenDice {

    @Test
    fun similarity() {
        val sorensenDice = SorensenDice(2)
        // AB BC CD DE DF FG
        // 1  1  1  1  0  0
        // 1  1  1  0  1  1
        // => 2 x 3 / (4 + 5) = 6/9 = 0.6666
        assertEquals(0.6666, sorensenDice.similarity("ABCDE", "ABCDFG"), 0.0001)
    }

    @Test
    fun distance() {
        val sorensenDice = SorensenDice(2)
        assertEquals(0.3333, sorensenDice.distance("ABCDE", "ABCDFG"), 0.0001)
    }
}
