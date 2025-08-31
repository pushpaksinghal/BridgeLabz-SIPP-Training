package MAP.GroupEmployeesByDepartment;

public class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public String getDepartment() {
        return this.department;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
