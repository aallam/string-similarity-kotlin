# Jaro

Jaro-Winkler is a string edit distance that was developed in the area of record linkage (duplicate detection) (Winkler,
1990). The Jaro–Winkler distance metric is designed and best suited for short strings such as person names, and to
detect transposition typos.

Jaro-Winkler computes the similarity between 2 strings, and the returned value lies in the interval [0.0, 1.0].
It is (roughly) a variation of Damerau-Levenshtein, where the transposition of 2 close characters is considered less
important than the transposition of 2 characters that are far from each other. Jaro-Winkler penalizes additions or
substitutions that cannot be expressed as transpositions.

The distance is computed as 1 - Jaro-Winkler similarity.

### Example

```kotlin
val jaroWinkler = JaroWinkler()

// substitution of s and t
println(jaroWinkler.similarity("My string", "My tsring"))

// substitution of s and n
println(jaroWinkler.similarity("My string", "My ntrisg"))
```

Output:

```
0.9740740617116292
0.8962963024775187
```

### Links

- [Jaro–Winkler distance](https://en.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance)
