public class employeemanagement {
    public static void main(String[] args) {
        // Create employee objects
        Emppp emp1 = new Emppp("Alice", "HR Manager", 101);
        Emppp emp2 = new Emppp("Bob", "Software Engineer", 102);

        // Display total number of employees
        Emppp.displayTotalEmployees();

        // Display company name (static variable)
        System.out.println("Company Name: " + Emppp.companyName);

        // Display employee details using instanceof
        Emppp.displayEmployeeDetails(emp1);
        Emppp.displayEmployeeDetails(emp2);

        // Test with a non-Employee object
        String notAnEmployee = "Random String";
        Emppp.displayEmployeeDetails(notAnEmployee);
    }
}

class Emppp {
    // Static variable shared by all employees
    public static String companyName = "Tech Solutions Pvt. Ltd.";
    private static int totalEmployees = 0;

    // Final variable for employee ID
    private final int id;

    // Instance variables
    private String name;
    private String designation;

    // Constructor using 'this'
    public Emppp(String name, String designation, int id) {
        this.name = name;
        this.designation = designation;
        this.id = id;
        totalEmployees++; // Increment total count on each new employee
    }

    // Static method to display total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details using instanceof
    public static void displayEmployeeDetails(Object obj) {
        if (obj instanceof Emppp) {
            Emppp e = (Emppp) obj;
            System.out.println("\nEmployee Details:");
            System.out.println("Name: " + e.name);
            System.out.println("ID: " + e.id);
            System.out.println("Designation: " + e.designation);
        } else {
            System.out.println("The object is not an Employee.");
        }
    }
}
