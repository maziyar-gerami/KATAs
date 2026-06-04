#  LRU Cache

## Difficulty

Advanced

## Estimated Time

120–180 minutes (including Unit Tests)

---

# Objective

Implement an in-memory **Least Recently Used (LRU) Cache**.

This kata introduces:

* HashMap + Doubly Linked List design
* State management
* Cache eviction policies
* Data structure composition
* Performance guarantees
* Object-oriented design

This is one of the most common senior-level interview problems.

---

# Background

An LRU Cache stores a limited number of items.

When the cache is full and a new item is added:

```text
Evict the least recently used item.
```

"Recently used" means:

* inserted
* read via `get`
* updated via `put`

---

# Requirements

Create a class:

```java
public class LruCache<K, V>
```

---

# Constructor

```java
public LruCache(int capacity)
```

Rules:

```text
capacity > 0
```

Otherwise:

```java
IllegalArgumentException
```

---

# API

Implement:

```java
void put(K key, V value)
```

```java
Optional<V> get(K key)
```

```java
int size()
```

```java
boolean containsKey(K key)
```

---

# Functional Rules

## Put

### New Key

Insert into cache.

---

### Existing Key

Update value.

Mark as most recently used.

---

## Get

### Existing Key

Return:

```java
Optional.of(value)
```

and mark item as most recently used.

---

### Missing Key

Return:

```java
Optional.empty()
```

---

# Eviction Rule

Capacity:

```java
2
```

Operations:

```java
put(A)
put(B)
get(A)
put(C)
```

Cache becomes:

```text
A, C
```

because:

```text
B
```

was least recently used.

---

# Example

## Input

```java
cache.put(1, "A");
cache.put(2, "B");

cache.get(1);

cache.put(3, "C");
```

---

## Result

```java
cache.containsKey(1) == true
cache.containsKey(2) == false
cache.containsKey(3) == true
```

---

# Performance Requirements

Target:

| Operation   | Complexity |
| ----------- | ---------- |
| put         | O(1)       |
| get         | O(1)       |
| containsKey | O(1)       |

---

# Important Restriction

Do NOT use:

```java
LinkedHashMap
```

for the primary implementation.

The purpose of this kata is to understand how an LRU cache works internally.

---

# Suggested Design

Use:

```java
HashMap<K, Node<K,V>>
```

plus

```java
Doubly Linked List
```

---

# Node

Example:

```java
class Node<K, V> {

    K key;
    V value;

    Node<K,V> prev;
    Node<K,V> next;
}
```

---

# Key Insight

The doubly linked list tracks usage order.

```text
HEAD
↓
Most Recently Used

...

Least Recently Used
↓
TAIL
```

---

# Operations

## Access Existing Item

Move node to head.

---

## Insert New Item

Insert at head.

---

## Capacity Exceeded

Remove tail.

---

# Unit Testing Requirements

Create tests for:

## Constructor

```java
capacity <= 0
```

throws exception.

---

## Put

```java
single item
multiple items
overwrite existing key
```

---

## Get

```java
existing key
missing key
```

---

## Eviction

```java
capacity reached
eviction after get()
eviction after update()
```

---

## Size

Verify after:

```java
insert
update
eviction
```

---

# Suggested Test Sequence

```java
cache.put(1, "A");
cache.put(2, "B");

cache.get(1);

cache.put(3, "C");
```

Expected:

```java
containsKey(1) == true
containsKey(2) == false
containsKey(3) == true
```

---

# Bonus Challenge 1

Implement:

```java
List<K> keysInUsageOrder()
```

Return:

```text
Most Recent → Least Recent
```

---

# Bonus Challenge 2

Make implementation thread-safe.

Consider:

```java
ReentrantLock
```

---

# Expected Complexity

## Target

### Put

O(1)

### Get

O(1)

### Contains

O(1)

---

# Evaluation Criteria

Your solution will be reviewed for:

* Correctness
* Data structure design
* OOP design
* Complexity guarantees
* Edge-case handling
* Test quality
* Clean Code
* Encapsulation

---

# Deliverables

1. Production code
2. Unit tests
3. Bonus implementations (optional)
4. Complexity analysis comments

---

# Mentor Hint

Before writing any code, draw this on paper:

```text
HEAD <-> A <-> B <-> C <-> TAIL
```

Then manually simulate:

```text
get(B)
put(D)
put(E)
```

If you can update the linked list correctly on paper, the code becomes much easier.

This is the first kata where data structure design is more important than Java syntax.
