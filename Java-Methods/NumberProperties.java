
public class NumberProperties {

    // Find sum of proper divisors
    public static int sumOfDivisors(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum;
    }

    // Check perfect number
    public static boolean isPerfect(int n) {
        return sumOfDivisors(n) == n;
    }

    // Check abundant number
    public static boolean isAbundant(int n) {
        return sumOfDivisors(n) > n;
    }

    // Check deficient number
    public static boolean isDeficient(int n) {
        return sumOfDivisors(n) < n;
    }

    // Check strong number (sum of factorial of digits == number)
    public static boolean isStrong(int n) {
        int sum = 0, original = n;
        while (n > 0) {
            int digit = n % 10;
            sum += factorial(digit);
            n /= 10;
        }
        return sum == original;
    }

    // Helper method: factorial
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }

    public static void main(String[] args) {
        int number = 145; // you can change this to test

        System.out.println("Is Perfect: " + isPerfect(number));
        System.out.println("Is Abundant: " + isAbundant(number));
        System.out.println("Is Deficient: " + isDeficient(number));
        System.out.println("Is Strong: " + isStrong(number));
    }
}
