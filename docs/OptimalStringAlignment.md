# Optimal String Alignment

The Optimal String Alignment variant of Damerau–Levenshtein (sometimes called the restricted edit distance) computes
the number of edit operations needed to make the strings equal under the condition that no substring is edited more than
once, whereas the true Damerau–Levenshtein presents no such restriction. The difference from the algorithm for
Levenshtein distance is the addition of one recurrence for the transposition operations.

Note that for the optimal string alignment distance, the triangle inequality does not hold and so it is not a true
metric.

### Example

```kotlin
val osa = OptimalStringAlignment()
println(osa.distance("CA", "ABC"))
```

Output:

```
3
```

### Links

- [Damerau–Levenshtein distance](https://en.wikipedia.org/wiki/Damerau%E2%80%93Levenshtein_distance#Optimal_string_alignment_distance)
