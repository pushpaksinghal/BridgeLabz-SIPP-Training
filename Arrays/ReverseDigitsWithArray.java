import java.util.Scanner;

public class ReverseDigitsWithArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int digits = (int)Math.log10(number) + 1;
        int[] arr = new int[digits];

        for (int i = 0; number > 0; i++) {
            arr[i] = number % 10;
            number /= 10;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
