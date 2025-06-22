
public class UnitConverter {

    // Convert kilometers to miles
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }

    // Convert miles to kilometers
    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }

    // Convert meters to feet
    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }

    // Convert feet to meters
    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }

    public static void main(String[] args) {
        System.out.println("5 km = " + convertKmToMiles(5) + " miles");
        System.out.println("3 miles = " + convertMilesToKm(3) + " km");
        System.out.println("10 meters = " + convertMetersToFeet(10) + " feet");
        System.out.println("30 feet = " + convertFeetToMeters(30) + " meters");
    }
}
