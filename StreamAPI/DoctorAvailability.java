package streamAPI;
import java.util.*;
//import java.util.stream.*;

class Doctor {
    String name, specialty;
    boolean weekendAvailable;
    Doctor(String name, String specialty, boolean weekendAvailable) {
        this.name = name; this.specialty = specialty; this.weekendAvailable = weekendAvailable;
    }
    public String toString() { return name + " - " + specialty; }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Mehta", "Cardiology", true),
            new Doctor("Dr. Singh", "Neurology", false),
            new Doctor("Dr. Rao", "Orthopedics", true),
            new Doctor("Dr. Roy", "Dermatology", true)
        );

        doctors.stream()
            .filter(d -> d.weekendAvailable)
            .sorted(Comparator.comparing(d -> d.specialty))
            .forEach(System.out::println);
    }
}