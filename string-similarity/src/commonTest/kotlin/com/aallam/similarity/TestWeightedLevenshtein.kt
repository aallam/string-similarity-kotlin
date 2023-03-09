package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestWeightedLevenshtein {

    @Test
    fun distance() {
        val operationCost = object : OperationsWeights {
            override fun substitution(first: Char, second: Char): Double {
                return if (first == 't' && second == 'r') 0.5 else 1.0
            }

            override fun deletion(char: Char): Double {
                return if (char == 'i') 0.8 else 1.0
            }

            override fun insertion(char: Char): Double {
                return if (char == 'i') 0.5 else 1.0
            }
        }

        val levenshtein = WeightedLevenshtein(operationCost)

        assertEquals(0.0, levenshtein.distance("String1", "String1"), 0.1)
        assertEquals(0.5, levenshtein.distance("String1", "Srring1"), 0.1)
        assertEquals(1.5, levenshtein.distance("String1", "Srring2"), 0.1)

        assertEquals(0.5, levenshtein.distance("Strng", "String"), 0.1)
        assertEquals(0.8, levenshtein.distance("String", "Strng"), 0.1)
        assertEquals(1.0, levenshtein.distance("Strig", "String"), 0.1)
        assertEquals(1.0, levenshtein.distance("String", "Strig"), 0.1)

        assertEquals(0.0, levenshtein.distance("String1", "String1", Double.MAX_VALUE), 0.1)
        assertEquals(0.0, levenshtein.distance("String1", "String1", 2.0), 0.1)
        assertEquals(0.5, levenshtein.distance("String1", "Srring1", Double.MAX_VALUE), 0.1)
        assertEquals(0.5, levenshtein.distance("String1", "Srring1", 2.0), 0.1)
        assertEquals(1.5, levenshtein.distance("String1", "Srring2", 2.0), 0.1)
        assertEquals(1.5, levenshtein.distance("String1", "Srring2", 1.5), 0.1)
        assertEquals(1.0, levenshtein.distance("String1", "Srring2", 1.0), 0.1)
        assertEquals(4.0, levenshtein.distance("String1", "Potato", 4.0), 0.1)
    }
}
