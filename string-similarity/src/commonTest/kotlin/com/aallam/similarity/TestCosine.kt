package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestCosine {

    @Test
    fun similarity() {
        val tests = listOf(
            TestCase("hello", "chello", 0.935),
            TestCase("hello", "hell", 0.926),
            TestCase("hello", "hellhole", 0.980),
            TestCase("hello", "hello", 1.0),
        )
        val cosine = Cosine(1)
        for (test in tests) {
            val similarity = cosine.similarity(test.s1, test.s2)
            assertEquals(test.value, similarity, 0.001)
        }
    }

    @Test
    fun distance() {
        val tests = listOf(
            TestCase("hello", "chello", 0.065),
            TestCase("hello", "hell", 0.074),
            TestCase("hello", "hellhole", 0.02),
            TestCase("hello", "hello", 0.0),
        )
        val cosine = Cosine(1)
        for (test in tests) {
            val distance = cosine.distance(test.s1, test.s2)
            assertEquals(test.value, distance, 0.001)
        }
    }
}

private data class TestCase(val s1: String, val s2: String, val value: Double, val tolerance: Double = 0.0)
