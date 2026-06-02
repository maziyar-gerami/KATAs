# Day 6 — Meeting Room Scheduler

## Difficulty

Intermediate → Advanced

## Estimated Time

90–120 minutes (including Unit Tests)

---

# Objective

Implement a utility that determines whether a person can attend all meetings without any scheduling conflicts.

This kata introduces:

* Interval overlap detection
* Sorting
* Comparator design
* Time complexity analysis
* Defensive programming
* Test-driven development

This is a very common interview problem and an excellent exercise for reasoning about ranges and ordering.

---

# Requirements

Create a class named:

```java
MeetingRoomScheduler
```

Create a record:

```java
public record Meeting(int start, int end) {
}
```

Implement the following method:

```java
boolean canAttendAll(List<Meeting> meetings)
```

---

# Functional Rules

1. A meeting is represented by:

```text
[start, end)
```

Meaning:

* start is inclusive
* end is exclusive

---

2. Two meetings overlap if:

```text
meeting1.end > meeting2.start
```

after sorting by start time.

---

3. Return:

```java
true
```

if all meetings can be attended.

Otherwise:

```java
false
```

---

4. Return:

```java
true
```

for:

* null input
* empty input
* single meeting

---

# Examples

## Example 1

Input:

```java
[
    (1, 3),
    (4, 6),
    (7, 10)
]
```

Output:

```java
true
```

---

## Example 2

Input:

```java
[
    (1, 5),
    (4, 8)
]
```

Output:

```java
false
```

---

## Example 3

Input:

```java
[
    (1, 3),
    (3, 5)
]
```

Output:

```java
true
```

Because:

```text
[1,3) and [3,5)
```

do not overlap.

---

# Validation Rules

A meeting is invalid when:

```text
start >= end
```

Example:

```java
(5,5)
(10,4)
```

Your implementation must throw:

```java
IllegalArgumentException
```

for invalid meetings.

---

# Suggested Approach

## Step 1

Sort by:

```java
start
```

ascending.

---

## Step 2

Compare neighboring meetings.

If:

```java
previous.end > current.start
```

return:

```java
false
```

---

## Step 3

Return:

```java
true
```

if no conflicts are found.

---

# Example Walkthrough

Input:

```java
[
    (5,8),
    (1,3),
    (4,6)
]
```

After sorting:

```java
[
    (1,3),
    (4,6),
    (5,8)
]
```

Now compare:

```text
3 > 4 ? no
6 > 5 ? yes
```

Conflict found.

Return:

```java
false
```

---

# Unit Testing Requirements

Create tests for:

## Valid Cases

```java
null
empty list
single meeting
non-overlapping meetings
touching meetings
unsorted meetings
```

---

## Invalid Cases

```java
overlapping meetings
multiple overlaps
```

---

## Validation Cases

```java
(5,5)
(10,4)
```

Expect:

```java
IllegalArgumentException
```

---

# Bonus Challenge 1

Implement:

```java
Optional<Meeting>
findFirstConflict(List<Meeting> meetings)
```

Return the first conflicting meeting.

---

# Bonus Challenge 2

Implement:

```java
int minimumRoomsRequired(List<Meeting> meetings)
```

Example:

```java
(1,5)
(2,6)
(7,8)
```

Result:

```java
2
```

Hint:

```java
PriorityQueue
```

---

# Expected Complexity

## Sorting Solution

Time Complexity:

O(n\log n)

Space Complexity:

O(n)

---

# Evaluation Criteria

Your solution will be reviewed for:

* Correctness
* Comparator usage
* Validation logic
* Exception handling
* Test quality
* Complexity awareness
* Clean Code
* API design

---

# Deliverables

1. Production code
2. Unit tests
3. Bonus solutions (optional)
4. Complexity analysis comments

---

# Mentor Hint

Before coding, answer:

1. Why must meetings be sorted first?
2. What happens if the input is already sorted?
3. Can overlap detection be done in a single pass after sorting?
4. Where should validation occur?
5. What is the invariant between two neighboring meetings?

Write those answers down before opening your IDE.
