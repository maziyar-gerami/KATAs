package service;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import domain.Employee;

public class EmployeeService {
    
    public List<Employee> rankEmployees(List<Employee> employees){
        return employees.stream()
        .sorted(new EmployeeComparator())
        .toList();
    }

    public static class EmployeeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee e1, Employee e2) {
            return Comparator.comparing(Employee::getPerformanceScore, Comparator.reverseOrder())
                    .thenComparing(Employee::getSalary, Comparator.reverseOrder())
                    .thenComparing(Employee::getName)
                    .compare(e1, e2);
        }
    }

    public Optional<Employee> findTopPerformerByDepartment(List<Employee> employees, String department) {
        return employees.stream()
        .filter(e -> e.getDepartment().equalsIgnoreCase(department))
        .max(new EmployeeComparator());
    }

    public Map<String, Double> averagePerformanceByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getPerformanceScore)));
    }
}
