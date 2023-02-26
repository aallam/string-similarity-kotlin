# Longest Common Subsequence

The longest common subsequence (LCS) problem consists in finding the longest subsequence common to two (or more)
sequences. It differs from problems of finding common substrings: unlike substrings, subsequences are not required
to occupy consecutive positions within the original sequences.

It is used by the diff utility, by Git for reconciling multiple changes, etc.

The LCS distance between strings `x` (of length `n`) and `y` (of length `m`) is `n + m - 2 |LCS(x, y)|`,
min = 0 and max = n + m

LCS distance is equivalent to Levenshtein distance when only insertion and deletion is allowed (no substitution), or
when the cost of the substitution is the double of the cost of an insertion or deletion.

In "Length of Maximal Common Subsequences", K.S. Larsen proposed an algorithm that computes the length of LCS in time 
*O(log(m).log(n))*. But the algorithm has a memory requirement *O(m.n²)* and was thus not implemented here.

### Example

````kotlin
val lcs = LongestCommonSubsequence()

println(lcs.distance("AGCAT", "GAC"))
println(lcs.distance("AGCAT", "AGCT"))
````

Output:

```
4
1
```

### Links

- [Longest common subsequence](https://en.wikipedia.org/wiki/Longest_common_subsequence)
