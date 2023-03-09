# Metric Longest Common Subsequence

Distance metric based on [Longest Common Subsequence](LongestCommonSubsequence.md), 
from the notes "An LCS-based string metric" by Daniel Bakkelund.

The distance is computed as `1 - |LCS(s1, s2)| / max(|s1|, |s2|)`

### Example


````kotlin
val lcs = MetricLCS()
println(lcs.distance("ABCDEFG", "ABCDEFHJKL"))
println(lcs.distance("ABDEF", "ABDIF"))
````

Output:

```
0.4
0.19999999999999996
```

### Links

- [An LCS-based string metric](https://www.researchgate.net/profile/Daniel-Bakkelund/publication/242065008_An_LCS-based_string_metric/links/57ff543b08ae56fae5f55421/An-LCS-based-string-metric.pdf)