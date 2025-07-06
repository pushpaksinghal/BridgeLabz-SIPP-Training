interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class BaseVehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    BaseVehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle: " + vehicleNumber + ", Type: " + type + ", Rate: $" + rentalRate + "/day");
    }
}

class RentalCar extends BaseVehicle implements Insurable {
    RentalCar(String number, double rate) {
        super(number, "Car", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 500;
    }

    public String getInsuranceDetails() {
        return "Car Insurance: Flat $500";
    }
}

class RentalBike extends BaseVehicle implements Insurable {
    RentalBike(String number, double rate) {
        super(number, "Bike", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9;
    }

    public double calculateInsurance() {
        return 200;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance: Flat $200";
    }
}

class RentalTruck extends BaseVehicle implements Insurable {
    RentalTruck(String number, double rate) {
        super(number, "Truck", rate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2;
    }

    public double calculateInsurance() {
        return 800;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance: Flat $800";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        BaseVehicle[] vehicles = {
            new RentalCar("CAR123", 100),
            new RentalBike("BIK456", 40),
            new RentalTruck("TRK789", 150)
        };

        for (BaseVehicle v : vehicles) {
            v.displayDetails();
            System.out.println("Rental for 5 days: $" + v.calculateRentalCost(5));
            if (v instanceof Insurable) {
                Insurable i = (Insurable) v;
                System.out.println(i.getInsuranceDetails());
                System.out.println("Insurance Cost: $" + i.calculateInsurance());
            }
            System.out.println();
        }
    }
}
