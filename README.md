# String Similarity for Kotlin

[![Maven Central](https://img.shields.io/maven-central/v/com.aallam.similarity/string-similarity-kotlin?color=blue&label=Download)](https://search.maven.org/artifact/com.aallam.similarity/string-similarity-kotlin)
[![License](https://img.shields.io/github/license/aallam/string-similarity-kotlin?color=yellow)](LICENSE)
[![Documentation](https://img.shields.io/badge/docs-dokka-a97bff)](https://mouaad.aallam.com/string-similarity-kotlin/)

This is a library that implements various measures of string similarity and distance.

## Install

Add the Maven Central repository if it is not already there:

```groovy
repositories {
    mavenCentral()
}
```

Add a dependency to the dependencies block:

```groovy
dependencies {
    implementation "com.aallam.similarity:string-similarity-kotlin:$version"
}
```

## Algorithms

The following is the list of implemented algorithms:

* [Levenshtein](guides/Levenshtein.md)
* [Normalized Levenshtein](guides/NormalizedLevenshtein.md)
* [Weighted Levenshtein](guides/WeightedLevenshtein.md)
* [Damerau-Levenshtein](guides/DamerauLevenshtein.md)
* [Optimal String Alignment](guides/OptimalStringAlignment.md)
* [Jaro-Winkler](guides/JaroWinkler.md)
* [Longest Common Subsequence](guides/LCS.md)
* [Metric Longest Common Subsequence](guides/MetricLCS.md)
* [N-Gram](guides/NGram.md)
* [Q-Gram](guides/QGram.md)
* [Cosine similarity](guides/CosineSimilarity.md)
* [Jaccard index](guides/JaccardIndex.md)
* [Sorensen-Dice coefficient](guides/SorensenDiceCoefficient.md)
* [Ratcliff-Obershelp](guides/RatcliffObershelp.md)

## Prior-Art

The library is a Kotlin port of [java-string-similarity](https://github.com/tdebatty/java-string-similarity).

## License

The library is an open-sourced software licensed under the [MIT license](LICENSE).
