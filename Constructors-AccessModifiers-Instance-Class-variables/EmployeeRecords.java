class Employees {
    public int employeeID;
    protected String department;
    private double salary;

    Employees(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void updateSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employees {
    String level;

    Manager(int employeeID, String department, double salary, String level) {
        super(employeeID, department, salary);
        this.level = level;
    }

    void display() {
        System.out.println("ID: " + employeeID + ", Dept: " + department + ", Salary: ₹" + getSalary() + ", Level: " + level);
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        Manager mgr = new Manager(1001, "HR", 75000, "Senior");
        mgr.display();
        mgr.updateSalary(80000);
        mgr.display();
    }
}
