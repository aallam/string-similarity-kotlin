# String Similarity for Kotlin

[![Maven Central](https://img.shields.io/maven-central/v/com.aallam.similarity/string-similarity-kotlin?color=blue&label=Download)](https://search.maven.org/artifact/com.aallam.similarity/string-similarity-kotlin)
[![License](https://img.shields.io/github/license/aallam/string-similarity-kotlin?color=yellow)](LICENSE)

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

* [Levenshtein](docs/Levenshtein.md)
* [Normalized Levenshtein](docs/NormalizedLevenshtein.md)
* [Weighted Levenshtein](docs/WeightedLevenshtein.md)
* [Damerau-Levenshtein](docs/DamerauLevenshtein.md)
* [Optimal String Alignment](docs/OptimalStringAlignment.md)
* [Jaro-Winkler](docs/JaroWinkler.md)
* [Longest Common Subsequence](docs/LCS.md)
* [Metric Longest Common Subsequence](docs/MetricLCS.md)
* [N-Gram](docs/NGram.md)
* [Q-Gram](docs/QGram.md)
* [Cosine similarity](docs/CosineSimilarity.md)
* [Jaccard index](docs/JaccardIndex.md)
* [Sorensen-Dice coefficient](docs/SorensenDiceCoefficient.md)
* [Ratcliff-Obershelp](docs/RatcliffObershelp.md)

## Prior-Art

The library is a Kotlin port of [java-string-similarity](https://github.com/tdebatty/java-string-similarity).

## License

The library is an open-sourced software licensed under the [MIT license](LICENSE).
