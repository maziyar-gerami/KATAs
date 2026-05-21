package domain;

import java.math.BigDecimal;

public class Employee {
    
    private final long id;
    private final String name;
    private final String department;
    private final BigDecimal salary;
    private final int performanceScore;

    public Employee(long id, String name, String department, BigDecimal salary, int performanceScore) {
        if (performanceScore<1 || performanceScore>100) 
            throw new IllegalArgumentException("Performance score must be between 1 and 100");
        if (salary.compareTo(BigDecimal.ZERO) < 0) 
            throw new IllegalArgumentException("Salary must be non-negative");
        if(name == null || name.isEmpty()) 
            throw new IllegalArgumentException("Name cannot be null or empty");
        if(department == null || department.isEmpty()) 
            throw new IllegalArgumentException("Department cannot be null or empty");
            
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.performanceScore = performanceScore;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public BigDecimal getSalary() {
        return salary;
    }
    public int getPerformanceScore() {
        return performanceScore;
    }

    @Override
    public String toString(){
        return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", department='" + department + '\'' +
            ", salary=" + salary +
            ", performanceScore=" + performanceScore +
            '}';
    }
}
