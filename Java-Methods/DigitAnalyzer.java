

import java.util.Arrays;

public class DigitAnalyzer {

    public static int[] getDigits(int num) {
        return String.valueOf(num).chars().map(c -> c - '0').toArray();
    }

    public static int sumOfDigits(int[] digits) {
        return Arrays.stream(digits).sum();
    }

    public static int sumOfSquares(int[] digits) {
        return Arrays.stream(digits).map(d -> (int) Math.pow(d, 2)).sum();
    }

    public static boolean isHarshad(int num) {
        int[] digits = getDigits(num);
        int sum = sumOfDigits(digits);
        return num % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2]; // digit, frequency
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int d : digits) freq[d][1]++;
        return freq;
    }

    public static void main(String[] args) {
        int number = 18;
        int[] digits = getDigits(number);

        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares: " + sumOfSquares(digits));
        System.out.println("Is Harshad: " + isHarshad(number));

        System.out.println("Digit Frequencies:");
        int[][] freq = digitFrequency(digits);
        for (int[] f : freq) {
            if (f[1] > 0)
                System.out.println(f[0] + " → " + f[1]);
        }
    }
}
