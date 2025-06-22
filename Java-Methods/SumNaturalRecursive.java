
import java.util.Scanner;

public class SumNaturalRecursive {

    // Recursive method to find sum
    public static int sumRecursive(int n) {
        if (n <= 1) return n;
        return n + sumRecursive(n - 1);
    }

    // Formula-based sum
    public static int sumFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number (greater than 0).");
        } else {
            int recSum = sumRecursive(n);
            int formulaSum = sumFormula(n);

            System.out.println("Sum using recursion: " + recSum);
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Both methods give same result: " + (recSum == formulaSum));
        }

        sc.close();
    }
}
