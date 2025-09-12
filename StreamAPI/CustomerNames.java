package streamAPI;
import java.util.*;

public class CustomerNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("rahul", "anita", "suresh", "priya", "vikram");

        names.stream()
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
    }
}