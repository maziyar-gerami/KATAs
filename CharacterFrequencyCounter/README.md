Day 1 — Character Frequency Counter
Difficulty

Intermediate (Entry Level)

Estimated Time

45–75 minutes (including Unit Tests)

Objective

Implement a utility that counts how many times each character appears in a given string.

The goal of this kata is to practice:

Map usage
Iteration techniques
Clean method design
Basic algorithmic thinking
Unit testing with JUnit 5 and AssertJ
Requirements

Create a class named:

CharacterFrequencyCounter

Implement the following method:

Map<Character, Integer> countCharacters(String input)
Functional Rules
Count all characters except spaces ' '
Uppercase and lowercase characters must be treated as different characters
Preserve insertion order in the result
Return an empty map for:
null
empty string
blank string
Do NOT use external libraries
Example
Input
"hello world"
Output
h -> 1
e -> 1
l -> 3
o -> 2
w -> 1
r -> 1
d -> 1
Technical Constraints
Preferred APIs

You are encouraged to use:

LinkedHashMap
Enhanced for-loop
Map#getOrDefault
Unit Testing Requirements

Create comprehensive unit tests covering:

Mandatory Test Cases
Null input
Empty string
Blank string
Repeated characters
Case sensitivity
Strings containing numbers
Strings containing symbols
Example Unit Test Scenario
countCharacters("aabcc")

Expected:

a -> 2
b -> 1
c -> 2
Suggested Project Structure
src
├── main
│   └── java
│       └── kata
│           └── CharacterFrequencyCounter.java
│
└── test
└── java
└── kata
└── CharacterFrequencyCounterTest.java