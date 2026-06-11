package service;

import domain.Employee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDepartmentServiceTest {

    public static Stream<Arguments> invalidEmployeesProvider() {
        return Stream.of(Arguments.of(List.of(new Employee("Maziyar", null), new Employee("Maziyar", "Dep1"))),
                Arguments.of(List.of(new Employee("Maziyar", "Dep1"), new Employee("Maziyar", ""))));
    }

    public static Stream<Arguments> validEmployeesProvider() {
        return Stream.of(Arguments.of(List.of(new Employee("Maziyar", "IT"), new Employee("Negar", "HR"),
                new Employee("Maziyar1", "IT"), new Employee("Maziyar2", "IT"))));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void employeeDepartment_whenEmployeeIsNullOrEmpty_returnEmptyMap(List<Employee> employees) {
        var expectedResult = Map.of();
        var result = EmployeeDepartmentService.countByDepartment(employees);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource(value = "invalidEmployeesProvider")
    void employeeDepartment_whenEmployeesContainInvalidEmployee_filterOutThem(List<Employee> employees) {
        var expectedResult = Map.of("Dep1", 1L);
        var result = EmployeeDepartmentService.countByDepartment(employees);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource(value = "validEmployeesProvider")
    void employeeDepartment_whenEmployeesAreValid_countThem(List<Employee> employees) {
        var expectedResult = Map.of(
                "HR", 1L,
                "IT", 3L);
        var result = EmployeeDepartmentService.countByDepartment(employees);
        assertEquals(expectedResult, result);
    }

}