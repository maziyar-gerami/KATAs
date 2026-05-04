# Text Analyzer (Java)

A simple command-based text analyzer written in Java.
This project demonstrates basic OOP design, enums, command parsing, and text processing in a console application.

## Features

Supported commands:
- COUNT_CHARS → count total characters
- COUNT_WORDS → count number of words
- UPPERCASE → convert text to uppercase
- LOWERCASE → convert text to lowercase
- REVERSE → reverse the text
- STATS → show simple text statistics
- EXIT → exit the application

## Project Structure

src/
  Main.java
  Command.java
  Action.java
  TextAnalyzer.java

## Example

Input:
Hello world from Java
COUNT_WORDS

Output:
Words count: 4

## Requirements

Java 17+

## Run

javac *.java
java Main

## Learning Goals

- Java enums
- switch expressions
- console input handling
- text processing

## License

Free for learning and experimentation.