import java.util.*;
public class volOfEarth {
    public static void main(String[] args) {
        //Volume of a Sphere is (4/3) * pi * r^3 and radius of earth is 6378 km
        double Earth_radius = 6378; // Radius of the Earth in kilometers
        double Earth_radius_miles = Earth_radius * 0.621371; // Convert radius to miles
        double vol1 = (4.0 / 3.0) * Math.PI * Math.pow(Earth_radius, 3); // Volume of the Earth in cubic kilometers
        double vol2 = (4.0 / 3.0) * Math.PI * Math.pow(Earth_radius_miles, 3); // Volume of the Earth in cubic Miles
        System.out.println("The volume of earth in cubic kilometers is "+vol1+" and cubic miles is "+vol2);
    }
}
