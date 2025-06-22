

import java.util.Scanner;

public class NumberArrayCheck {

    // Check if a number is positive
    public static boolean isPositive(int num) {
        return num > 0;
    }

    // Check if a number is even
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    // Compare two numbers: return 1 if a > b, 0 if equal, -1 if a < b
    public static int compare(int a, int b) {
        if (a > b) return 1;
        else if (a == b) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        // Input 5 numbers
        System.out.println("Enter 5 integers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }

        // Process each number
        for (int num : numbers) {
            if (isPositive(num)) {
                System.out.println(num + " is positive and " + (isEven(num) ? "even" : "odd"));
            } else {
                System.out.println(num + " is negative");
            }
        }

        // Compare first and last elements
        int result = compare(numbers[0], numbers[4]);
        if (result == 0) System.out.println("First and last elements are equal.");
        else if (result == 1) System.out.println("First element is greater than last.");
        else System.out.println("First element is less than last.");

        sc.close();
    }
}
