import java.util.*;

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                dept.addEmployee(employeeName);
                return;
            }
        }
    }

    public void showStructure() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            System.out.println(" Department: " + dept.getName());
            dept.showEmployees();
        }
    }

    private class Department {
        private String name;
        private List<Employee> employees;

        public Department(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        public void addEmployee(String employeeName) {
            employees.add(new Employee(employeeName));
        }

        public String getName() {
            return name;
        }

        public void showEmployees() {
            for (Employee emp : employees) {
                System.out.println("  Employee: " + emp.getName());
            }
        }

        private class Employee {
            private String name;

            public Employee(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }
    }
}

public class companyanddepartment {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        company.addDepartment("IT");
        company.addDepartment("HR");

        company.addEmployeeToDepartment("IT", "Alice");
        company.addEmployeeToDepartment("IT", "Bob");
        company.addEmployeeToDepartment("HR", "Carol");

        company.showStructure();

        company = null;
        System.gc();
    }
}
