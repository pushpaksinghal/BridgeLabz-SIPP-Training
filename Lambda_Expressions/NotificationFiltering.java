package Lambda_Expressions;

import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;

    public Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Critical", "Patient heart rate abnormal."),
            new Alert("Normal", "Daily health tip available."),
            new Alert("Warning", "High blood sugar detected."),
            new Alert("Info", "New hospital policy update.")
        );

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter preferred alert type (Critical/Warning/Normal/Info): ");
        String preference = sc.nextLine().trim();

        // Predicate for filtering based on user preference
        Predicate<Alert> filterByPreference = alert -> alert.type.equalsIgnoreCase(preference);

        System.out.println("\n=== Filtered Alerts ===");
        alerts.stream()
              .filter(filterByPreference)
              .forEach(System.out::println);

        sc.close();
    }
}

