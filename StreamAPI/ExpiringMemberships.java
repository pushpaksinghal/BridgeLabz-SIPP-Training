package streamAPI;
import java.time.*;
import java.util.*;


class Member {
    String name;
    LocalDate expiryDate;
    Member(String name, LocalDate expiryDate) {
        this.name = name; this.expiryDate = expiryDate;
    }
    public String toString() { return name + " expires on " + expiryDate; }
}

public class ExpiringMemberships {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("Amit", LocalDate.now().plusDays(10)),
            new Member("Riya", LocalDate.now().plusDays(40)),
            new Member("Vikas", LocalDate.now().plusDays(25)),
            new Member("Sneha", LocalDate.now().plusDays(5))
        );

        members.stream()
            .filter(m -> m.expiryDate.isBefore(LocalDate.now().plusDays(30)))
            .forEach(System.out::println);
    }
}