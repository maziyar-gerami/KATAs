# Kata: Consecutive Number Analyzer

## Difficulty

Easy → Medium

## Goal

Given a list of integers, analyze consecutive pairs of numbers.

For every two neighboring numbers:

- Calculate their absolute difference.
- Count how many pairs have a difference less than or equal to a threshold.
- Find the largest difference.

## Example

Input:

```text
Numbers:
[10, 13, 15, 20, 18, 25]

Threshold:
3
```

Neighbor pairs are:

| Pair | Difference |
|------|------------|
|10 → 13|3|
|13 → 15|2|
|15 → 20|5|
|20 → 18|2|
|18 → 25|7|

Result:

```text
Pairs within threshold: 3
Largest difference: 7
```

---

## Requirements

Implement the following method:

```java
AnalysisResult analyze(List<Integer> numbers, int threshold)
```

Where `AnalysisResult` contains:

- `int pairsWithinThreshold`
- `int largestDifference`

---

## Constraints

- The list contains at least two numbers.
- The list may contain negative values.
- The list may contain duplicate values.

---

## Hint

Instead of iterating over the elements themselves, iterate over their **indexes**.

Think about generating:

```java
0, 1, 2, ..., size - 2
```

For each index `i`, compare:

```java
numbers.get(i)
numbers.get(i + 1)
```

There is a Stream API class specifically designed for streaming integer ranges.

---

## Expected Example

Input:

```java
List.of(4, 8, 10, 9, 15)
```

Differences:

```
4
2
1
6
```

Threshold = 3

Output:

```
pairsWithinThreshold = 2
largestDifference = 6
```

---

## Bonus Challenges

### Bonus 1

Return the average difference.

### Bonus 2

Return the index of the pair with the largest difference.

Example:

```
20 -> 18
```

Index:

```
3
```

because the pair starts at index 3.

### Bonus 3

Return all differences as a list.

Example:

```
[3, 2, 5, 2, 7]
```

---

## Recommended APIs

- `IntStream.range()`
- `map()`
- `filter()`
- `max()`
- `count()`
- `summaryStatistics()`
- `Math.abs()`