# Anagram Validator

## Difficulty

Intermediate

## Estimated Time

60–90 minutes (including Unit Tests)

---

# Objective

Implement a utility that determines whether two strings are anagrams of each other.

An anagram is a word or phrase formed by rearranging the letters of another word or phrase.

Examples:

* `listen` ↔ `silent`
* `rail safety` ↔ `fairy tales`

---

# Requirements

Create a class named:

```java
AnagramValidator
```

Implement the following method:

```java
boolean isAnagram(String first, String second)
```

---

# Functional Rules

1. Comparison must be case-insensitive.
2. Ignore whitespace.
3. Ignore punctuation.
4. Return `false` if either argument is `null`.
5. Return `true` if both strings are valid anagrams.

---

# Valid Examples

| First       | Second      | Result |
| ----------- | ----------- | ------ |
| listen      | silent      | true   |
| triangle    | integral    | true   |
| Rail Safety | Fairy Tales | true   |
| Dormitory   | Dirty Room  | true   |

---

# Invalid Examples

| First | Second     | Result |
| ----- | ---------- | ------ |
| hello | world      | false  |
| java  | javascript | false  |
| abc   | abcd       | false  |

---

# Technical Constraints

Do not sort the strings.

Use a frequency-counting approach.

Recommended:

```java
Map<Character, Integer>
```

---

# Suggested Algorithm

1. Normalize both strings.
2. Compare lengths.
3. Count character frequencies.
4. Verify all frequencies match.

---

# Unit Testing Requirements

Create tests for:

* null input
* empty strings
* different lengths
* valid anagrams
* invalid anagrams
* case-insensitive comparison
* whitespace handling
* punctuation handling

---

# Bonus Challenge

Implement a second version using:

```java
int[256]
```

instead of a Map.

Compare:

* readability
* memory usage
* performance

---

# Expected Complexity

Time Complexity:

O(n)

Space Complexity:

O(k)

Where:

* n = string length
* k = unique character count

---

# Evaluation Criteria

* Correctness
* Clean Code
* Test Coverage
* Edge-Case Handling
* Complexity Awareness
* API Design

---

# Deliverables

1. Production code
2. Unit tests
3. Optional array-based implementation
