import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SmartCitySystem{
    public static void main(String[]args){
        List<InnerTransportService> services =Arrays.asList(
            new BusService("City bus", 1.5, "Every 30 mins"),
            new AmbulanceService("City ambulance", 0.0, "24/7"),
            new TaxiService("City taxi", 2.0, "On demand"),
            new MetroService("City metro", 1.0, "Every 15 mins")
        );

         System.out.println("Affordable Services (<20):");
        services.stream()
                .filter(s -> s.getfare() < 20)
                .sorted(Comparator.comparing(InnerTransportService::getfare)) 
                .forEach(InnerTransportService::printServiceDetails);

        FareCalculator calculator = (distance, rate) -> distance * rate;
        double fare = calculator.calculateFare(5, 3); 
        System.out.println("Calculated Fare: " + fare);

        DoubleSummaryStatistics stats = services.stream()
                .collect(Collectors.summarizingDouble(InnerTransportService::getfare));
        System.out.println("Total Revenue: " + stats.getSum() + 
                           ", Avg Fare: " + stats.getAverage());

        Map<Class<?>, List<InnerTransportService>> grouped =
                services.stream().collect(Collectors.groupingBy(Object::getClass));
        System.out.println("Grouped Services: " + grouped);

        services.stream()
                .filter(s -> s instanceof EmergencyService)
                .forEach(s -> System.out.println("Emergency Priority: " + s.getname()));

        double dist = GeoUtils.calculateDistance(12.9, 77.6, 13.0, 77.7);
        System.out.println("Distance: " + dist);
    }
}