package streamAPI;
import java.util.*;

public class EventWelcome {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList("Rahul", "Anita", "Suresh", "Priya");
        attendees.forEach(name -> System.out.println("Welcome, " + name + "!"));
    }
}