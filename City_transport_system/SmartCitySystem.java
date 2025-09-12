import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SmartCitySystem{
    public static void main(String[]args){
        List<InnerTransportService> services =Arrays.asList(
            new BusService("City bus", 1.5, "Every 30 mins"),
            new AmbulanceService("City ambulance", 0.0, "24/7"),
            new TaxiService("City taxi", 2.0, "On demand"),
            new MetroService("City metro", 1.0, "Every 15 mins")
        );

         System.out.println("Affordable Services (<2):");
        services.stream()
                .filter(s -> s.getfare() < 2.0)
                .sorted(Comparator.comparing(InnerTransportService::getfare)) 
                .forEach(InnerTransportService::printServiceDetails);

        FareCalculator calculator = (distance, rate) -> distance * rate;
        double fare = calculator.calculateFare(5, 3); 
        System.out.println("Calculated Fare: " + fare);

        double dist = GeoUtils.calculateDistance(12.9, 77.6, 13.0, 77.7);
        System.out.println("Distance: " + dist);
    }
}