package departmentstatisticbuilder;

public record DepartmentStats(
        long employeeCount,
        int totalSalary,
        double averageSalary
) {
}