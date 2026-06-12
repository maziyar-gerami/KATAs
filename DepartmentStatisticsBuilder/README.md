# Department Statistics Builder

## Difficulty
Intermediate → Early Advanced

## Estimated Time
60–90 minutes

---

# Problem

Given a list of employees, build statistics per department.

---

## Model

```java
public record Employee(
    String name,
    String department,
    int salary
) {}
Output Model
public record DepartmentStats(
    long employeeCount,
    int totalSalary,
    double averageSalary
) {}
Function Signature
public static Map<String, DepartmentStats> buildStats(List<Employee> employees)
```
Rules
1. Input validation


Return:

Map.of()

if:

employees is null
employees is empty
2. Ignore invalid employees

Ignore employees where:

department is null
department is blank
salary < 0
3. Calculation per department

For each department:

employeeCount → number of valid employees
totalSalary → sum of salaries
averageSalary → totalSalary / employeeCount (double)
Example
Input
IT: 1000, 2000
HR: 3000
Output
{
  IT = DepartmentStats(2, 3000, 1500.0),
  HR = DepartmentStats(1, 3000, 3000.0)
}