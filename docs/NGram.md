# N-Gram

Normalized N-Gram distance as defined by Kondrak, "N-Gram Similarity and Distance", String Processing and Information
Retrieval, Lecture Notes in Computer Science Volume 3772, 2005, pp 115-126.

The algorithm uses affixing with special character '\n' to increase the weight of first characters. The normalization is
achieved by dividing the total similarity score the original length of the longest word.

### Example

```kotlin
val twogram = NGram(2);
println(twogram.distance("ABCD", "ABTUIO"))

val s1 = "Adobe CreativeSuite 5 Master Collection from cheap 4zp"
val s2 = "Adobe CreativeSuite 5 Master Collection from cheap d1x"
val ngram = NGram(4)
println(ngram.distance(s1, s2))
```

Output:

```
0.5833333333333334
0.027777777777777776
```

### Links

- [N-Gram Similarity and Distance](http://webdocs.cs.ualberta.ca/~kondrak/papers/spire05.pdf)
