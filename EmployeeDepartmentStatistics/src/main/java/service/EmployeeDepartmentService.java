package service;

import domain.Employee;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeDepartmentService {

    public static Map<String, Long> countByDepartment(List<Employee> employees) {
        if (employees == null || employees.isEmpty())
            return Map.of();

        return employees.stream()
                .filter(e -> e.department() != null && !e.department().isBlank())
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
    }
}
