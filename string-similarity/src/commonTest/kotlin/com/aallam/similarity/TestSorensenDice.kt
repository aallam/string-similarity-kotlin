/*
 * The MIT License
 *
 * Copyright 2015 Thibault Debatty.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestSorensenDice {

    @Test
    fun testSimilarity() {
        val sorensenDice = SorensenDice(2)
        // AB BC CD DE DF FG
        // 1  1  1  1  0  0
        // 1  1  1  0  1  1
        // => 2 x 3 / (4 + 5) = 6/9 = 0.6666
        assertEquals(0.6666, sorensenDice.similarity("ABCDE", "ABCDFG"), 0.0001)
    }

    @Test
    fun testDistance() {
        val sorensenDice = SorensenDice(2)
        assertEquals(0.3333, sorensenDice.distance("ABCDE", "ABCDFG"), 0.0001)
    }
}