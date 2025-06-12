import java.util.*;

public class kilointomiles2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double kilo = sc.nextDouble(); // Read input in kilometers
        double miles = kilo * 0.621371; // Convert kilometers to miles
        System.out.println(kilo + " kilometers is equal to " + miles + " miles.");
        sc.close(); 
    }
}
