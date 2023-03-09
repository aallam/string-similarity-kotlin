# Weighted Levenshtein

It is possible to define different weights for different character substitutions.
This is usually used for optical character recognition (OCR) applications.
For OCR, the cost of substituting P and R is lower than the cost of substituting P and M for example because from and
OCR point of view P is similar to R.

It can also be used for keyboard typing autocorrection. Here the cost of substituting E and R is lower for example
because these are located next to each other on an AZERTY or QWERTY keyboard.
Hence, the probability that the user mistyped the characters is higher.

### Example

```kotlin
val weights = object : OperationsWeights {
    override fun substitution(first: Char, second: Char): Double {
        // The cost for substituting 't' and 'r' is considered
        // smaller as these 2 are located next to each other
        // on a keyboard
        if (first == 't' && second == 'r') return 0.5

        // For most cases, the cost of substituting 2 characters
        // is 1.0
        return 1.0
    }
}
val levenshtein = Levenshtein(weights)
print(levenshtein.distance("kitten", "kirtn"))
```

Output:

```
1.5
```

### Links

- [Levenshtein distance](https://en.wikipedia.org/wiki/Levenshtein_distance)
- [Wagner–Fischer algorithm](https://en.wikipedia.org/wiki/Wagner%E2%80%93Fischer_algorithm)
