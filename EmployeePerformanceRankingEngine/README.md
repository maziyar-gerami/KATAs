# Day 3 / 200

## Employee Performance Ranking Engine

**Difficulty:** Medium  
**Estimated Solve Time:** 30 minutes  

---

## Concepts Practiced

- Comparator chaining
- Multi-field sorting
- Optional usage
- Stream transformations
- Immutable domain modeling
- Clean API design

---

## Problem Description

You are building an internal employee performance ranking engine.

Each employee has:

- `id` (long)
- `name` (String)
- `department` (String)
- `salary` (BigDecimal)
- `performanceScore` (int, 1–100)

Your task is to implement ranking and filtering logic.

---

## Requirements

Create:

### 1️⃣ Immutable `Employee` class

- All fields must be `final`
- Constructor validation:
  - `performanceScore` must be between 1 and 100
  - `salary` must be positive
  - `name` and `department` cannot be null or blank

---

### 2️⃣ `EmployeeService` class with the following methods:

#### ✅ `List<Employee> rankEmployees(List<Employee> employees)`

Return employees sorted by:

1. Highest `performanceScore`
2. If tie → Higher `salary`
3. If tie → Alphabetical `name`

Sorting must be stable and use `Comparator` chaining.

---

#### ✅ `Optional<Employee> findTopPerformerByDepartment(List<Employee> employees, String department)`

- Return the best ranked employee within a department.
- If no employee exists in that department → return `Optional.empty()`
- Must reuse ranking logic (avoid duplication).

---

#### ✅ `Map<String, Double> averagePerformanceByDepartment(List<Employee> employees)`

Return average performance score per department.

Example:
