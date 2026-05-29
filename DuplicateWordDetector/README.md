Duplicate Word Detector
Difficulty

Intermediate

Estimated Time

60–90 minutes (including Unit Tests)

Objective

Implement a utility that detects duplicated words in a sentence while preserving the order of their first duplication.

This kata focuses on:

Collections (Set, Map)
String normalization
Algorithmic thinking
Clean API design
Unit testing
Time complexity awareness
Requirements

Create a class named:

DuplicateWordDetector

Implement the following method:

List<String> findDuplicates(String text)
Functional Rules
Words are separated by whitespace
Ignore punctuation marks:
.
,
!
?
:
;
Comparison must be case-insensitive
Preserve the order of first duplicate appearance
Return only unique duplicate words
Return an empty list for:
null
empty string
blank string
Example
Input
"Java is great and java is powerful"
Output
["java", "is"]
Explanation

Occurrences:

Word	Count
java	2
is	2
great	1
and	1
powerful	1

The duplicate appearance order is:

java
is
Technical Constraints
You Must Use

At least one of:

HashSet
LinkedHashSet
Map
Recommended APIs

You are encouraged to use:

String#split
String#replaceAll
Pattern
Set#add
Important Edge Cases
Input
"Hello hello HELLO"
Output
["hello"]
Input
"One, two, two! three THREE?"
Output
["two", "three"]
Unit Testing Requirements

Create tests for:

null input
empty input
blank input
no duplicates
one duplicate
multiple duplicates
punctuation handling
case insensitivity
duplicate appearing many times
Suggested Design Hint

A common clean approach is:

One Set for seen words
One LinkedHashSet for duplicates
Suggested Project Structure
src
├── main
│   └── java
│       └── kata
│           └── DuplicateWordDetector.java
│
└── test
└── java
└── kata
└── DuplicateWordDetectorTest.java
Bonus Challenges (Optional)
Bonus 1

Return duplicate counts too:

Map<String, Integer>
Bonus 2

Make punctuation configurable

Bonus 3

Support Unicode punctuation

Expected Complexity
Target Time Complexity

O(n)

Target Space Complexity

O(n)