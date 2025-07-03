interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setDepartment(String dept) {
        this.department = dept;
    }

    public String getDepartment() {
        return department;
    }

    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Final Salary: $" + calculateSalary());
    }

    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee implements Department {
    private double bonus;

    FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void assignDepartment(String dept) {
        setDepartment(dept);
    }

    @Override
    public String getDepartmentDetails() {
        return "Full-Time Department: " + getDepartment();
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void assignDepartment(String dept) {
        setDepartment(dept);
    }

    @Override
    public String getDepartmentDetails() {
        return "Part-Time Department: " + getDepartment();
    }
}

public class EmployeeMan {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];

        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 50000, 8000);
        emp1.assignDepartment("Engineering");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 50, 120);
        emp2.assignDepartment("Support");

        employees[0] = emp1;
        employees[1] = emp2;

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println();
        }
    }
}
