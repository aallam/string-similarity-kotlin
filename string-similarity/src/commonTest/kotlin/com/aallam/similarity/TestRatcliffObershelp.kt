package com.aallam.similarity

import kotlin.test.Test
import kotlin.test.assertEquals

class TestRatcliffObershelp {

    @Test
    fun similarity() {
        val ratcliffObershelp = RatcliffObershelp()

        // test data from other algorithms
        // "My string" vs "My tsring"
        // Substrings:
        // "ring" ==> 4, "My s" ==> 3, "s" ==> 1
        // Ratcliff-Obershelp = 2*(sum of substrings)/(length of s1 + length of s2)
        //                    = 2*(4 + 3 + 1) / (9 + 9)
        //                    = 16/18
        //                    = 0.888888
        assertEquals(0.888888, ratcliffObershelp.similarity("My string", "My tsring"), 0.000001)

        // test data from other algorithms
        // "My string" vs "My tsring"
        // Substrings:
        // "My " ==> 3, "tri" ==> 3, "g" ==> 1
        // Ratcliff-Obershelp = 2*(sum of substrings)/(length of s1 + length of s2)
        //                    = 2*(3 + 3 + 1) / (9 + 9)
        //                    = 14/18
        //                    = 0.777778
        assertEquals(0.777778, ratcliffObershelp.similarity("My string", "My ntrisg"), 0.000001)

        // test data from essay by Ilya Ilyankou
        // "Comparison of Jaro-Winkler and Ratcliff/Obershelp algorithms
        // in spell check"
        // https://ilyankou.files.wordpress.com/2015/06/ib-extended-essay.pdf
        // p13, expected result is 0.857
        assertEquals(0.857, ratcliffObershelp.similarity("MATEMATICA", "MATHEMATICS"), 0.001)

        // test data from stringmetric
        // https://github.com/rockymadden/stringmetric
        // expected output is 0.7368421052631579
        assertEquals(0.736842, ratcliffObershelp.similarity("aleksander", "alexandre"), 0.000001)

        // test data from stringmetric
        // https://github.com/rockymadden/stringmetric
        // expected output is 0.6666666666666666
        assertEquals(0.666666, ratcliffObershelp.similarity("pennsylvania", "pencilvaneya"), 0.000001)

        // test data from wikipedia
        // https://en.wikipedia.org/wiki/Gestalt_Pattern_Matching
        // expected output is 14/18 = 0.7777777777777778‬
        assertEquals(0.777778, ratcliffObershelp.similarity("WIKIMEDIA", "WIKIMANIA"), 0.000001)

        // test data from wikipedia
        // https://en.wikipedia.org/wiki/Gestalt_Pattern_Matching
        // expected output is 24/40 = 0.65
        assertEquals(0.6, ratcliffObershelp.similarity("GESTALT PATTERN MATCHING", "GESTALT PRACTICE"), 0.000001)
    }

    @Test
    fun distance() {
        val ratcliffObershelp = RatcliffObershelp()
        assertEquals(0.111111, ratcliffObershelp.distance("My string", "My tsring"), 0.000001)
    }
}
