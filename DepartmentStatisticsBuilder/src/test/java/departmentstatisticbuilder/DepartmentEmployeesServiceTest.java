package departmentstatisticbuilder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentEmployeesServiceTest {

    @ParameterizedTest
    @NullAndEmptySource
    void departmentStatisticsBuilder_givenNullOrEmptyEmployees_shouldReturnEmptyMap(List<Employee> employees) {
        var result = DepartmentEmployeesService.buildStats(employees);
        assertEquals(Map.of(), result);
    }

    @Test
    void departmentStatisticsBuilder_givenValidEmployees_shouldGroupByDepartment() {
        List<Employee> employees = List.of(
                new Employee("A", "HR", 100),
                new Employee("B", "HR", 200),
                new Employee("C", "IT", 300),
                new Employee("D", "IT", 500),
                new Employee("E", "IT", 200)
        );

        var result = DepartmentEmployeesService.buildStats(employees);

        assertEquals(2, result.size());
        assertTrue(result.containsKey("HR"));
        assertTrue(result.containsKey("IT"));
    }

    @Test
    void departmentStatisticsBuilder_givenValidEmployees_shouldCalculateCorrectStats() {
        List<Employee> employees = List.of(
                new Employee("A", "HR", 100),
                new Employee("B", "HR", 300)
        );

        var result = DepartmentEmployeesService.buildStats(employees);

        DepartmentStats hrStats = result.get("HR");

        assertEquals(2L, hrStats.employeeCount());
        assertEquals(400, hrStats.totalSalary());
        assertEquals(200.0, hrStats.averageSalary(), 0.0001);
    }

    @Test
    void departmentStatisticsBuilder_shouldFilterInvalidEmployees() {
        List<Employee> employees = List.of(
                new Employee("A", null, 100),        // invalid
                new Employee("B", "", 200),          // invalid
                new Employee("C", "HR", -50),        // invalid
                new Employee("D", "HR", 150)         // valid
        );

        var result = DepartmentEmployeesService.buildStats(employees);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("HR"));

        DepartmentStats stats = result.get("HR");

        assertEquals(1L, stats.employeeCount());
        assertEquals(150, stats.totalSalary());
        assertEquals(150.0, stats.averageSalary(), 0.0001);
    }
}