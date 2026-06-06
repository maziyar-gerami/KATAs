# First Non-Repeating Character

## Difficulty

Intermediate

## Estimated Time

45–75 minutes (including Unit Tests)

---

# Objective

Given a string, find the **first character that appears exactly once**.

This kata strengthens:

* HashMap usage
* Frequency counting
* Order preservation
* Two-pass algorithms
* Unit testing

---

# Examples

## Example 1

### Input

```java
"swiss"
```

### Frequencies

```text
s -> 3
w -> 1
i -> 1
```

### Result

```java
'w'
```

---

## Example 2

### Input

```java
"level"
```

### Frequencies

```text
l -> 2
e -> 2
v -> 1
```

### Result

```java
'v'
```

---

## Example 3

### Input

```java
"aabbcc"
```

### Result

```java
Optional.empty()
```

---

# Requirements

Create:

```java
public class FirstNonRepeatingCharacter
```

Implement:

```java
public static Optional<Character> find(String text)
```

---

# Rules

## Return Empty Optional For

```java
null
""
"   "
```

---

## Ignore Character Case

These should be treated as the same character:

```text
A == a
```

Example:

```java
"AaBbC"
```

Frequencies:

```text
a -> 2
b -> 2
c -> 1
```

Result:

```java
'C'
```

Notice:

* Comparison is case-insensitive.
* Returned character should preserve its original casing from the input.

---

## Ignore Whitespaces

Input:

```java
"a b a c"
```

Process as:

```text
abac
```

Result:

```java
'b'
```

---

# Suggested Approach

## Pass 1

Build frequencies.

Example:

```java
{
    'a' -> 2,
    'b' -> 1,
    'c' -> 1
}
```

---

## Pass 2

Iterate through the original string.

Return the first character whose frequency is:

```java
1
```

---

# Unit Testing Requirements

Create tests for:

## Validation

```java
null
""
"   "
```

---

## Single Character

```java
"a"
```

Expected:

```java
Optional.of('a')
```

---

## Normal Cases

```java
"swiss"  -> w
"level"  -> v
```

---

## No Unique Character

```java
"aabbcc"
```

Expected:

```java
Optional.empty()
```

---

## Case Insensitive

```java
"AaBbC"
```

Expected:

```java
Optional.of('C')
```

---

## Ignore Spaces

```java
"a b a c"
```

Expected:

```java
Optional.of('b')
```

---

# Bonus Challenge

Implement:

```java
public static int indexOfFirstUnique(String text)
```

Return:

```java
-1
```

when no unique character exists.

Example:

```java
"swiss"
```

Result:

```java
1
```

because:

```text
s w i s s
0 1 2 3 4
```

and `w` is the first unique character.

---

# Expected Complexity

```text
Time:  O(n)
Space: O(n)
```

---

# Evaluation Criteria

Your solution will be reviewed for:

* Correctness
* Edge-case handling
* Readability
* Test quality
* Complexity awareness
* Appropriate collection usage

---

# Mentor Hint

Many developers try to solve this in one pass.

A much cleaner solution is:

```text
Pass 1 -> Count
Pass 2 -> Find
```

Two simple passes are often better than one complicated pass.
