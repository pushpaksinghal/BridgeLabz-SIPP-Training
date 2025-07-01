public class VehicleRegistration {
    public static void main(String[] args) {
        // Update registration fee for all vehicles
        Vehicle.updateRegistrationFee(1500.0);

        // Create Vehicle objects
        Vehicle v1 = new Vehicle("Ravi Sharma", "Car", "DL10AB1234");
        Vehicle v2 = new Vehicle("Priya Mehta", "Bike", "MH12XY9876");

        // Display vehicle details using instanceof
        Vehicle.displayRegistrationDetails(v1);
        Vehicle.displayRegistrationDetails(v2);

        // Try with a non-vehicle object
        String notAVehicle = "Just a string";
        Vehicle.displayRegistrationDetails(notAVehicle);
    }
}

class Vehicle {
    // Static variable shared by all vehicles
    private static double registrationFee = 1000.0;

    // Final variable to uniquely identify a vehicle
    private final String registrationNumber;

    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Constructor using 'this'
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
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
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;
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
