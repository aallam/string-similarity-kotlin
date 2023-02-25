# Levenshtein

The Levenshtein distance between two words is the minimum number of single-character edits (insertions, deletions or
substitutions) required to change one word into the other.

It is a metric string distance. This implementation uses dynamic programming (Wagner–Fischer algorithm), with only
2 rows of data. The space requirement is thus O(m) and the algorithm runs in O(m.n).

### Example

```kotlin
val levenshtein = Levenshtein()
println(levenshtein.distance("kitten", "kirten"))
```

Output:

```
1.0
```

### Links

- [Levenshtein distance](https://en.wikipedia.org/wiki/Levenshtein_distance)
- [Wagner–Fischer algorithm](https://en.wikipedia.org/wiki/Wagner%E2%80%93Fischer_algorithm)
