🎯 Objective

Build a system to process a list of financial transactions. You must filter, group, and aggregate data using Java Streams while ensuring the code is resilient to edge cases.

📝 Task Description

Implement a service method that processes a collection of transactions to provide a summary of spending per category.

The logic must:





Filter out all transactions that are not in COMPLETED status.



Filter out transactions with an amount less than or equal to 0.



Group the remaining transactions by their Category.



Calculate the total sum of transaction amounts for each category.

🏗 Technical Requirements





Language: Java 17+ (using Records).



Tooling: JUnit 5, AssertJ.



Input: List<Transaction>



Output: Map<Category, Double>

📋 Domain Model

public enum Status {
PENDING, COMPLETED, REJECTED
}

public enum Category {
GROCERIES, ENTERTAINMENT, UTILITIES, RENT, OTHER
}

public record Transaction(String id, double amount, Category category, Status status) {}


📥 Acceptance Criteria





Use Java Streams for the core logic.



Ensure the method is "Null-Safe" (handle null or empty lists).



Code must follow Clean Code principles (meaningful naming, small methods).



Provide a test suite covering:





A standard list of various transactions.



An empty list.



A list containing only rejected or zero-amount transactions.

Estimated Time: 40 Minutes (Logic + Unit Tests).