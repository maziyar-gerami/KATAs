# 🚀 Employee Department Statistics

## Difficulty

Intermediate

## Estimated Time

45–75 minutes (including tests)

---

# Problem

Given a list of employees, calculate how many employees belong to each department.

---

## Model

Create:

```java
public record Employee(
        String name,
        String department
) {
}
```

---

## Function Signature

```java
public static Map<String, Long> countByDepartment(
        List<Employee> employees)
```

---

# Rules

## Return

```java
Map.of()
```

when:

* employees is null
* employees is empty

---

## Ignore Invalid Employees

Employees with:

```text
null department
blank department
```

must be ignored.

---

# Example 1

Input:

```java
List.of(
    new Employee("Ali", "IT"),
    new Employee("Sara", "HR"),
    new Employee("Reza", "IT")
)
```

Output:

```java
Map.of(
    "IT", 2L,
    "HR", 1L
)
```

---

# Example 2

Input:

```java
List.of(
    new Employee("Ali", "IT"),
    new Employee("Sara", ""),
    new Employee("Reza", null)
)
```

Output:

```java
Map.of(
    "IT", 1L
)
```

---

# Example 3

Input:

```java
List.of(
    new Employee("Ali", "IT"),
    new Employee("Reza", "IT"),
    new Employee("Maryam", "IT")
)
```

Output:

```java
Map.of(
    "IT", 3L
)
```

---

# Unit Tests

Create tests for:

## Validation

```text
null
empty list
```

---

## Single Employee

```text
one valid employee
```

---

## Multiple Departments

```text
IT
HR
Finance
```

---

## Repeated Departments

```text
IT
IT
IT
```

---

## Invalid Employees

```text
null department
blank department
```

---

# Expected Complexity

```text
Time: O(n)
Space: O(k)
```

where:

```text
k = number of departments
```

---

# Learning Goal

Today you're learning your first truly common backend pattern:

```text
List<Object>
    ↓
groupingBy(object property)
    ↓
counting()
```

You'll use this pattern constantly in Spring Boot services, reporting APIs, analytics endpoints, and dashboard calculations.
