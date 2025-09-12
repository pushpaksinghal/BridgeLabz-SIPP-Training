package streamAPI;
import java.util.*;

public class SensorReadings {
    public static void main(String[] args) {
        List<Integer> readings = Arrays.asList(45, 78, 30, 90, 55);
        int threshold = 50;

        readings.stream()
            .filter(r -> r > threshold)
            .forEach(r -> System.out.println("High reading: " + r));
    }
}