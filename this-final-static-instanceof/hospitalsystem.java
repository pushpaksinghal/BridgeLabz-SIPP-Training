public class hospitalsystem {
    public static void main(String[] args) {
        // Create Patient objects
        Patient p1 = new Patient("Anita Verma", 35, "Flu", 1001);
        Patient p2 = new Patient("Rohit Mehra", 50, "Diabetes", 1002);

        // Display hospital name
        System.out.println("Hospital Name: " + Patient.hospitalName);

        // Display total number of patients
        Patient.getTotalPatients();

        // Display details using instanceof
        Patient.displayPatientDetails(p1);
        Patient.displayPatientDetails(p2);

        // Test with a non-Patient object
        String notAPatient = "Some text";
        Patient.displayPatientDetails(notAPatient);
    }
}

class Patient {
    // Static variable shared among all patients
    public static String hospitalName = "Sunrise Hospital";
    private static int totalPatients = 0;

    // Final variable for unique identification
    private final int patientID;

    // Instance variables
    private String name;
    private int age;
    private String ailment;

    // Constructor using 'this'
    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    // Static method to return total number of patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Method to display patient details using instanceof
    public static void displayPatientDetails(Object obj) {
        if (obj instanceof Patient) {
            Patient p = (Patient) obj;
            System.out.println("\nPatient Details:");
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Ailment: " + p.ailment);
            System.out.println("Patient ID: " + p.patientID);
        } else {
            System.out.println("The object is not a Patient.");
        }
    }
}
