# Sorensen-Dice coefficient

Similar to Jaccard index, but this time the similarity is computed as 2 * |V1 inter V2| / (|V1| + |V2|).

Distance is computed as 1 - similarity.

### Example

```kotlin
val sorensenDice = SorensenDice(2)
println(sorensenDice.similarity("ABCDE", "ABCDFG"))
```

Output:

```
0.6666666666666666
```

### Links

- [Sørensen–Dice coefficient](https://en.wikipedia.org/wiki/S%C3%B8rensen%E2%80%93Dice_coefficient)
