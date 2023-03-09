# Normalized Levenshtein

This distance is computed as [levenshtein](Levenshtein.md) distance divided by the length of the longest string.
The resulting value is always in the interval 0 to 1.

### Example

```kotlin
val levenshtein = NormalizedLevenshtein()
println(levenshtein.similarity("kitten", "kirten"))
```

Output:

```
0.8333333333333334
```

### Links

[Levenshtein Distance](https://en.wikipedia.org/wiki/Levenshtein_distance)
