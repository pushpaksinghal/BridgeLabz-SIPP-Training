package Lambda_Expressions.Method_References;

import java.util.*;

public class PatientIDPrinting {
    public static void main(String[] args) {
        List<String> patientIds = Arrays.asList(
            "PID001", "PID002", "PID003", "PID004", "PID005"
        );

        System.out.println("=== Hospital Patient IDs ===");

        patientIds.forEach(System.out::println);
    }
}

