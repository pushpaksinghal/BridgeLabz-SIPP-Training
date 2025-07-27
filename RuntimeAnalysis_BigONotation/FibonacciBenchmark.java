public class FibonacciBenchmark {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int smallN = 30;
        int largeN = 50;

        // Recursive (Small N only)
        long startRecursive = System.nanoTime();
        int resultRecursive = fibonacciRecursive(smallN);
        long endRecursive = System.nanoTime();
        System.out.println("Recursive Fibonacci (" + smallN + "): " + resultRecursive +
                " | Time: " + (endRecursive - startRecursive) / 1_000_000.0 + " ms");

        // Iterative (Large N)
        long startIterative = System.nanoTime();
        int resultIterative = fibonacciIterative(largeN);
        long endIterative = System.nanoTime();
        System.out.println("Iterative Fibonacci (" + largeN + "): " + resultIterative +
                " | Time: " + (endIterative - startIterative) / 1_000_000.0 + " ms");
    }
}
