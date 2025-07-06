interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate/km: $" + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

class RideCar extends RideVehicle implements GPS {
    private String location;

    RideCar(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }

    public void updateLocation(String location) {
        this.location = location;
    }

    public String getCurrentLocation() {
        return location;
    }
}

class RideBike extends RideVehicle implements GPS {
    private String location;

    RideBike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public void updateLocation(String location) {
        this.location = location;
    }

    public String getCurrentLocation() {
        return location;
    }
}

class RideAuto extends RideVehicle implements GPS {
    private String location;

    RideAuto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }

    public void updateLocation(String location) {
        this.location = location;
    }

    public String getCurrentLocation() {
        return location;
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        RideVehicle[] rides = new RideVehicle[3];

        RideCar car = new RideCar("C123", "Alex", 12);
        car.updateLocation("Downtown");

        RideBike bike = new RideBike("B456", "Nina", 8);
        bike.updateLocation("City Mall");

        RideAuto auto = new RideAuto("A789", "Ravi", 10);
        auto.updateLocation("Metro Station");

        rides[0] = car;
        rides[1] = bike;
        rides[2] = auto;

        for (RideVehicle r : rides) {
            r.getVehicleDetails();
            if (r instanceof GPS) {
                System.out.println("Location: " + ((GPS) r).getCurrentLocation());
            }
            System.out.println("Fare for 10km: $" + r.calculateFare(10));
            System.out.println();
        }
    }
}
