# Q-Gram

Q-gram distance, as defined by Ukkonen in *Approximate string-matching with q-grams and maximal matches**.

The distance between two strings is defined as the L1 norm of the difference of their profiles (the number of occurences
of each n-gram). Q-gram distance is a lower bound on Levenshtein distance, but can be computed in *O(m+n)*, where
Levenshtein requires *O(m.n)*.

### Example

```kotlin
val qGram = QGram(2)
println(qGram.distance("ABCD", "ABCE"))
```

Output:

```
2
```

### Links

- [Approximate string-matching with q-grams and maximal matches](http://www.sciencedirect.com/science/article/pii/0304397592901434)
