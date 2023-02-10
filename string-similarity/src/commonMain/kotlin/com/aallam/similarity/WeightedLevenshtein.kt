package com.aallam.similarity

import kotlin.math.min

/**
 * Implementation of Levenshtein that allows to define different weights for different character substitutions.
 *
 * @param weights the strategy to determine character operations weights.
 */
public class WeightedLevenshtein(
    private val weights: OperationsWeights
) {

    public fun distance(first: CharSequence, second: CharSequence, limit: Double = Double.MAX_VALUE): Double {
        if (first == second) return 0.0
        if (first.isEmpty()) return second.length.toDouble()
        if (second.isEmpty()) return first.length.toDouble()

        // initial costs is the edit distance from an empty string, which corresponds to the characters to insert.
        // the array size is : length + 1 (empty string)
        var cost = DoubleArray(first.length + 1)
        var newCost = DoubleArray(first.length + 1)

        first.forEachIndexed { i, char ->
            cost[i + 1] = cost[i] + weights.insertion(char)
        }

        for (i in 1..second.length) {

            // calculate new costs from the previous row.
            // the first element of the new row is the edit distance (deletes) to match empty string
            val secondChar = second[i - 1]
            val deletionCost = weights.deletion(secondChar)
            newCost[0] = cost[0] + deletionCost

            var minCost = newCost[0]

            // fill in the rest of the row
            for (j in 1..first.length) {
                // if it's the same char at the same position, no edit cost.
                val firstChar = first[j - 1]
                val edit = if (firstChar == secondChar) 0.0 else weights.substitution(firstChar, secondChar)
                val replace = cost[j - 1] + edit
                val insert = cost[j] + weights.insertion(secondChar)
                val delete = newCost[j - 1] + weights.deletion(firstChar)
                newCost[j] = minOf(insert, delete, replace)
                minCost = min(minCost, newCost[j])
            }

            if (minCost >= limit) return limit

            // flip references of current and previous row
            val swap = cost
            cost = newCost
            newCost = swap
        }

        return cost.last()
    }
}

/**
 * Used to indicate the cost of character operations (add, replace, delete).
 * The cost should always be in the range `[O, 1]`.
 *
 * Default implementation of all operations is `1.0`.
 *
 * Examples:
 * - In an OCR application, cost('o', 'a') could be 0.4.
 * - In a check-spelling application, cost('u', 'i') could be 0.4 because these are next to each other on the keyboard.
 */
public interface OperationsWeights {

    /**
     * Indicate the cost of substitution.
     * The cost in the range `[0, 1]`.
     *
     * @param first first character of the substitution.
     * @param second second character of the substitution.
     */
    public fun substitution(first: Char, second: Char): Double = 1.0

    /**
     * Get the cost to delete a given character.
     * The cost in the range `[0, 1]`.
     *
     * @param char the character being inserted.
     */
    public fun deletion(char: Char): Double = 1.0

    /**
     * Get the cost to insert a given character.
     * The cost in the range `[0, 1]`.
     *
     * @param char the character being inserted.
     */
    public fun insertion(char: Char): Double = 1.0

    public companion object
}
