# Cosine similarity

The similarity between the two strings is the cosine of the angle between these two vectors representation, and is
computed as V1 . V2 / (|V1| * |V2|)

Distance is computed as 1 - cosine similarity.

### Example

```kotlin
val cosine = Cosine(k = 2)
println(cosine.similarity("hello", "chello"))
```

Output:

```
0.8944271909999159
```

### Links

- [Cosine Similarity](https://en.wikipedia.org/wiki/Cosine_similarity)
