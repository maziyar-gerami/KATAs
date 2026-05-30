# Top K Frequent Elements

## Difficulty

Intermediate → Advanced

## Estimated Time

90–120 minutes (including Unit Tests)

---

# Objective

Implement a utility that returns the `k` most frequently occurring elements in a list.

This kata introduces:

* Frequency counting
* Priority queues (heaps)
* Custom comparators
* Sorting strategies
* Complexity trade-offs
* Test-driven thinking

This is a classic interview problem that appears frequently in senior backend and platform engineering interviews.

---

# Requirements

Create a class named:

```java
TopKFrequentElements
```

Implement the following method:

```java
List<Integer> findTopK(List<Integer> numbers, int k)
```

---

# Functional Rules

1. Return the `k` most frequent numbers.
2. Results must be ordered by frequency descending.
3. If two numbers have the same frequency, smaller numbers come first.
4. Return an empty list when:

    * input is `null`
    * input is empty
    * `k <= 0`
5. If `k` is greater than the number of unique elements, return all unique elements.
6. Negative numbers are allowed.

---

# Example 1

## Input

```text
numbers = [1,1,1,2,2,3]
k = 2
```

## Output

```text
[1,2]
```

### Explanation

| Number | Frequency |
| ------ | --------- |
| 1      | 3         |
| 2      | 2         |
| 3      | 1         |

Top 2 frequent elements:

```text
[1,2]
```

---

# Example 2

## Input

```text
numbers = [4,4,1,1,2,2]
k = 2
```

## Output

```text
[1,2]
```

### Explanation

All have frequency:

| Number | Frequency |
| ------ | --------- |
| 4      | 2         |
| 1      | 2         |
| 2      | 2         |

Same frequency → smaller number first.

Therefore:

```text
[1,2]
```

---

# Example 3

## Input

```text
numbers = [-1,-1,-2,-2,-2,3]
k = 2
```

## Output

```text
[-2,-1]
```

---

# Constraints

```text
1 <= n <= 100000
```

You should think about scalability.

---

# Suggested Approaches

## Approach 1

Frequency Map + Sorting

```java
Map<Integer, Long>
```

Then sort by:

1. Frequency descending
2. Number ascending

---

## Approach 2 (Bonus)

Use:

```java
PriorityQueue
```

to improve scalability.

---

# Unit Testing Requirements

Create tests for:

* null input
* empty input
* k = 0
* k < 0
* k = 1
* k > unique count
* duplicate values
* equal frequencies
* negative numbers
* single-element list

---

# Suggested Test Cases

## Case 1

```java
findTopK(List.of(1,1,2), 1)
```

Expected:

```java
List.of(1)
```

---

## Case 2

```java
findTopK(List.of(5,5,5), 10)
```

Expected:

```java
List.of(5)
```

---

## Case 3

```java
findTopK(List.of(3,3,2,2,1,1), 2)
```

Expected:

```java
List.of(1,2)
```

---

# Bonus Challenge

Implement a second method:

```java
List<Integer> findTopKUsingHeap(List<Integer> numbers, int k)
```

using:

```java
PriorityQueue
```

Compare:

* Runtime complexity
* Memory usage
* Readability

---

# Expected Complexity

## Sorting Approach

Time Complexity:

O(n log n)

Space Complexity:

O(n)

---

## Heap Approach

Time Complexity:

O(n log k)

Space Complexity:

O(n)

---

# Evaluation Criteria

Your solution will be reviewed for:

* Correctness
* Comparator design
* Collection usage
* Edge-case handling
* Complexity awareness
* Test quality
* Readability
* Scalability

---

# Deliverables

1. Production code
2. Unit tests
3. Optional heap-based implementation
4. Complexity analysis in comments
