# Damerau-Levenshtein

Similar to [Levenshtein](Levenshtein.md), Damerau-Levenshtein distance with transposition (also sometimes calls
unrestricted Damerau-Levenshtein distance) is the minimum number of operations needed to transform one string into
the other, where an operation is defined as an insertion, deletion, or substitution of a single character,
or a transposition of two adjacent characters.

It does respect triangle inequality, and is thus a metric distance.

This is not to be confused with the [optimal string alignment](OptimalStringAlignment.md) distance, which is an
extension where no substring can be edited more than once.

### Example

```kotlin
val damerau = DamerauLevenshtein()

// 1 substitution
println(damerau.distance("ABCDEF", "ABDCEF"))

// 2 substitutions
println(damerau.distance("ABCDEF", "BACDFE"))

// 1 deletion
println(damerau.distance("ABCDEF", "ABCDE"))

// All different
println(damerau.distance("ABCDEF", "POIU"))
```

Output:

```
1
2
1
4
```

### Links

- [Damerau–Levenshtein distance](https://en.wikipedia.org/wiki/Damerau%E2%80%93Levenshtein_distance)
