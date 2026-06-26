# Inventory Value by Category

## Difficulty

Intermediate

## Estimated Time

45–75 minutes (including Unit Tests)

---

# Problem

Calculate the **total inventory value per category**.

---

## Model

```java
public record Product(
    String name,
    String category,
    int price
) {}
```

---

## Function Signature

```java
public static Map<String, Integer> totalValueByCategory(List<Product> products)
```

---

# Rules

### Return

```java
Map.of()
```

when:

* `products` is `null`
* `products` is empty

---

### Ignore Invalid Products

Ignore products where:

* `category` is `null`
* `category` is blank
* `price < 0`

---

# Example 1

### Input

```java
List.of(
    new Product("Laptop", "Electronics", 1000),
    new Product("Phone", "Electronics", 500),
    new Product("Desk", "Furniture", 300)
)
```

### Output

```java
Map.of(
    "Electronics", 1500,
    "Furniture", 300
)
```

---

# Example 2

### Input

```java
List.of(
    new Product("Laptop", "Electronics", 1000),
    new Product("Bad Product", "", 999),
    new Product("Broken", null, 500),
    new Product("Invalid", "Electronics", -10)
)
```

### Output

```java
Map.of(
    "Electronics", 1000
)
```

---

# 💡 Hint

Before writing code, try to complete:

```java
products.stream()
        .filter( ??? )
        .collect(Collectors.groupingBy(
                ???,
                Collectors.summingInt( ??? )
        ));
```

If you can fill in those three `???`, you're about 90% of the way to the solution.

---

# Unit Tests

Create tests for the following scenarios:

## Validation

* `null` input
* empty list

---

## Single Category

All products belong to one category.

---

## Multiple Categories

For example:

* Electronics
* Furniture
* Books

---

## Invalid Products

* `null` category
* blank category
* negative price

---

## Aggregation Correctness

Verify that prices are summed correctly for each category.

---

# Expected Complexity

```text
Time: O(n)
Space: O(k)
```

Where:

```text
k = number of distinct categories
```

---

# 🎯 Learning Goal

Today you'll learn one of the most useful collectors in Java Streams:

```java
Collectors.summingInt(...)
```

This collector is widely used in:

* Reporting APIs
* Analytics Services
* Financial Applications
* Inventory Systems
* Spring Boot Backend Services
