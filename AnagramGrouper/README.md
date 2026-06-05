# Group Anagrams

## Difficulty

Intermediate → Advanced

## Estimated Time

60–90 minutes (including Unit Tests)

---

# Objective

Given a list of strings, group together words that are anagrams of each other.

---

# Examples

## Example 1

### Input

```java
List.of(
    "eat",
    "tea",
    "tan",
    "ate",
    "nat",
    "bat"
)
```

### Output

```java
[
    List.of("eat", "tea", "ate"),
    List.of("tan", "nat"),
    List.of("bat")
]
```

---

## Example 2

### Input

```java
List.of("abc", "bca", "cab")
```

### Output

```java
[
    List.of("abc", "bca", "cab")
]
```

---

# Requirements

Create:

```java
public class AnagramGrouper
```

Implement:

```java
public static List<List<String>> group(List<String> words)
```

---

# Rules

## Return Empty List For

```java
null
empty list
```

---

## Case Insensitive

These belong to the same group:

```java
"Listen"
"Silent"
```

---

## Preserve Original Words

Input:

```java
"Listen"
"Silent"
```

Output should contain:

```java
List.of("Listen", "Silent")
```

and **must not** convert them to lowercase in the result.

---

# Hint

Two words are anagrams if their sorted characters are equal.

Example:

```text
eat -> aet
tea -> aet
ate -> aet
```

Use the sorted version as the grouping key.

---

# Suggested Approach

Use:

```java
Map<String, List<String>>
```

Where:

```text
key   = sorted characters
value = words belonging to that group
```

Example:

```text
"aet" -> ["eat","tea","ate"]
"ant" -> ["tan","nat"]
```

---

# Unit Testing Requirements

Create tests for:

## Validation

```java
null
empty list
```

---

## Basic Group

```java
["eat","tea","ate"]
```

Expected:

```java
[
    ["eat","tea","ate"]
]
```

---

## Multiple Groups

```java
["eat","tea","tan","ate","nat","bat"]
```

Expected:

```java
[
    ["eat","tea","ate"],
    ["tan","nat"],
    ["bat"]
]
```

---

## Case Insensitive

```java
["Listen","Silent"]
```

Expected:

```java
[
    ["Listen","Silent"]
]
```

---

## Single Word

```java
["java"]
```

Expected:

```java
[
    ["java"]
]
```

---

# Bonus Challenge

Implement:

```java
public static Map<String, List<String>> groupAsMap(List<String> words)
```

where the key is the normalized anagram signature.

Example:

```java
{
    "aet" = ["eat","tea","ate"],
    "ant" = ["tan","nat"]
}
```

---

# Expected Complexity

Let:

```text
n = number of words
k = average word length
```

Then:

```text
Time Complexity:  O(n × k log k)
Space Complexity: O(n × k)
```

because each word must be normalized and sorted once.

---

# Evaluation Criteria

Your solution will be reviewed for:

* Correctness
* Test Coverage
* Edge Case Handling
* Collection Usage
* Clean Code
* Complexity Awareness
* Naming and Readability

---

# Deliverables

1. Production code
2. Unit tests
3. Complexity analysis
4. Bonus solution (optional)

---

# Mentor Hint

Before writing any code, manually build the following map:

```text
eat    -> aet
tea    -> aet
ate    -> aet
tan    -> ant
nat    -> ant
bat    -> abt
```

Once you see that multiple words can produce the same key, the solution becomes almost trivial.
