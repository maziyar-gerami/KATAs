import java.math.BigDecimal;
import java.util.List;

import domain.Employee;
import service.EmployeeService;

public class App {
    public static void main(String[] args) throws Exception {
        List<Employee> employees = List.of(
            new Employee(1, "Alice Johnson", "Engineering", new BigDecimal("95000.00"), 92),
            new Employee(2, "Bob Smith", "Sales", new BigDecimal("72000.00"), 78),
            new Employee(3, "Clara Davis", "Human Resources", new BigDecimal("68000.00"), 85),
            new Employee(4, "Blara Davis", "Human Resources", new BigDecimal("68000.00"), 85),
            new Employee(5, "Daniel Brown", "Finance", new BigDecimal("88000.00"), 89),
            new Employee(6, "Emma Wilson", "Marketing", new BigDecimal("76000.00"), 74)
        );

        EmployeeService employeeService = new EmployeeService();

        System.out.println("Ranked Employees:");
        employeeService.rankEmployees(employees).forEach(System.out::println);

        System.out.println("\nTop Performer in Engineering:");
        employeeService.findTopPerformerByDepartment(employees, "Human Resources").ifPresentOrElse(
            System.out::println,
            () -> System.out.println("No employee found in Engineering department.")
        );

        System.out.println("\nAverage Performance by Department:");
        employeeService.averagePerformanceByDepartment(employees).forEach((dept, avg) ->
            System.out.println(dept + ": " + avg)
        );
    }
}
