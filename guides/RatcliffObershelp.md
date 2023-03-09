# Ratcliff-Obershelp

Ratcliff/Obershelp Pattern Recognition, also known as Gestalt Pattern Matching, is a string-matching algorithm for
determining the similarity of two strings. It was developed in 1983 by John W. Ratcliff and John A. Obershelp and
published in the Dr. Dobb's Journal in July 1988

Ratcliff/Obershelp computes the similarity between 2 strings, and the returned value lies in the interval [0.0, 1.0].

The distance is computed as 1 - Ratcliff/Obershelp similarity.

### Example

```kotlin
val ratcliffObershelp = RatcliffObershelp()
println(ratcliffObershelp.similarity("My string", "My tsring"))
println(ratcliffObershelp.similarity("My string", "My ntrisg"))
```

Output:

```
0.8888888888888888
0.7777777777777778
```

### Links

- [Comparison of Jaro-Winkler and Ratcliff/Obershelp algorithms in spell check](https://ilyankou.files.wordpress.com/2015/06/ib-extended-essay.pdf)
- [Gestalt pattern matching](https://en.wikipedia.org/wiki/Gestalt_pattern_matching)
