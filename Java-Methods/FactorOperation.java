
public class FactorOperation {

    // Find all factors
    public static int[] findFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0) count++;

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= n; i++)
            if (n % i == 0) factors[index++] = i;
        return factors;
    }

    // Greatest factor (excluding the number itself)
    public static int greatestFactor(int[] factors, int original) {
        int max = 1;
        for (int f : factors)
            if (f < original && f > max)
                max = f;
        return max;
    }

    // Sum of factors
    public static int sum(int[] factors) {
        int total = 0;
        for (int f : factors) total += f;
        return total;
    }

    // Product of factors
    public static long product(int[] factors) {
        long prod = 1;
        for (int f : factors) prod *= f;
        return prod;
    }

    // Product of cubes of factors
    public static long cubeProduct(int[] factors) {
        long prod = 1;
        for (int f : factors)
            prod *= Math.pow(f, 3);
        return prod;
    }

    public static void main(String[] args) {
        int num = 12;  // Test number
        int[] factors = findFactors(num);

        System.out.print("Factors of " + num + ": ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println();

        System.out.println("Greatest Proper Factor: " + greatestFactor(factors, num));
        System.out.println("Sum of Factors: " + sum(factors));
        System.out.println("Product of Factors: " + product(factors));
        System.out.println("Product of Cubes: " + cubeProduct(factors));
    }
}
