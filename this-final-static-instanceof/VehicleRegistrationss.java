public class VehicleRegistrationss {
    public static void main(String[] args) {
        // Update registration fee for all vehicles
        ehicless.updateRegistrationFee(1500.0);

        // Create Vehicle objects
        ehicless v1 = new ehicless("Ravi Sharma", "Car", "DL10AB1234");
        ehicless v2 = new ehicless("Priya Mehta", "Bike", "MH12XY9876");

        // Display vehicle details using instanceof
        ehicless.displayRegistrationDetails(v1);
        ehicless.displayRegistrationDetails(v2);

        // Try with a non-vehicle object
        String notAVehicle = "Just a string";
        ehicless.displayRegistrationDetails(notAVehicle);
    }
}

class ehicless {
    // Static variable shared by all vehicles
    private static double registrationFee = 1000.0;

    // Final variable to uniquely identify a vehicle
    private final String registrationNumber;

    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Constructor using 'this'
    public ehicless(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update the registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Updated Registration Fee: ₹" + registrationFee);
    }

    // Method to display vehicle details using instanceof
    public static void displayRegistrationDetails(Object obj) {
        if (obj instanceof ehicless) {
            ehicless v = (ehicless) obj;
            System.out.println("\nVehicle Registration Details:");
            System.out.println("Owner Name: " + v.ownerName);
            System.out.println("Vehicle Type: " + v.vehicleType);
            System.out.println("Registration Number: " + v.registrationNumber);
            System.out.println("Registration Fee: ₹" + registrationFee);
        } else {
            System.out.println("The object is not a Vehicle.");
        }
    }
}
