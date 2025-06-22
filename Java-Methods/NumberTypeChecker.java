
public class NumberTypeChecker {

    // Prime number check
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    // Neon number: square of number, sum of digits == number
    public static boolean isNeon(int n) {
        int square = n * n;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == n;
    }

    // Spy number: sum of digits == product of digits
    public static boolean isSpy(int n) {
        int sum = 0, prod = 1, temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            prod *= digit;
            temp /= 10;
        }
        return sum == prod;
    }

    // Automorphic number: square ends with the number itself
    public static boolean isAutomorphic(int n) {
        int square = n * n;
        String numStr = String.valueOf(n);
        String squareStr = String.valueOf(square);
        return squareStr.endsWith(numStr);
    }

    // Buzz number: divisible by 7 or ends with 7
    public static boolean isBuzz(int n) {
        return n % 7 == 0 || n % 10 == 7;
    }

    public static void main(String[] args) {
        int num = 7;  // You can change this to test other numbers

        System.out.println("Number: " + num);
        System.out.println("Is Prime: " + isPrime(num));
        System.out.println("Is Neon: " + isNeon(num));
        System.out.println("Is Spy: " + isSpy(num));
        System.out.println("Is Automorphic: " + isAutomorphic(num));
        System.out.println("Is Buzz: " + isBuzz(num));
    }
}
