import java.util.Scanner;

public class LargestTwoDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] digits = new int[10];
        int index = 0;

        while (number > 0 && index < 10) {
            digits[index++] = number % 10;
            number /= 10;
        }

        int max1 = 0, max2 = 0;
        for (int i = 0; i < index; i++) {
            if (digits[i] > max1) {
                max2 = max1;
                max1 = digits[i];
            } else if (digits[i] > max2 && digits[i] != max1) {
                max2 = digits[i];
            }
        }

        System.out.println("Largest: " + max1);
        System.out.println("Second Largest: " + max2);
    }
}
