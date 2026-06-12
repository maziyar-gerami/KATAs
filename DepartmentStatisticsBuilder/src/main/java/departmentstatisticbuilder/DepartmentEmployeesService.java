package departmentstatisticbuilder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DepartmentEmployeesService {

    public static Map<String, DepartmentStats> buildStats(List<Employee> employees) {
        if (employees == null || employees.isEmpty())
            return Map.of();

        return employees.stream()
                .filter(DepartmentEmployeesService::filterValidEmployee)
                .collect(Collectors.groupingBy(Employee::department, Collectors.collectingAndThen(Collectors.toList(),
                        DepartmentEmployeesService::toDepartmentStats)));
    }

    private static DepartmentStats toDepartmentStats(List<Employee> departmentEmployees) {
        long count = departmentEmployees.size();
        int totalSalary = departmentEmployees.stream().mapToInt(Employee::salary).sum();
        double salaryAvg = (count > 0) ? (double) totalSalary / count : 0D;

        return new DepartmentStats(count, totalSalary, salaryAvg);
    }

    private static boolean filterValidEmployee(Employee employee) {
        return employee.department() != null &&
                !employee.department().isBlank() && employee.salary() >= 0;
    }
}
