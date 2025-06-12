import java.util.Scanner;

public class heightintofeet {
    public static void main(String[] args) {
        //1 foot = 12 inches and 1 inch = 2.54 cm
        Scanner sc = new Scanner(System.in);
        Double cm = sc.nextDouble(); // Read input in centimeters
        Double noOFinches = cm  / 2.54; // Convert  centimeters to inches
        Double noOFeet = noOFinches / 12; // Convert inches to feet
        Double remainingInches = noOFinches % 12; // Calculate remaining inches after converting to feet
        System.out.println("Your Height in cm is "+cm+" while in feet is "+noOFeet+" and "+remainingInches+" inches.");


    }
}
