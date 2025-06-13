import java.util.Scanner;

public class largenumber {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();

        boolean isFirstLargest = (number1 > number2) && (number1 > number3);
        boolean isSecondLargest = (number2 > number1) && (number2 > number3);
        boolean isThirdLargest = (number3 > number1) && (number3 > number2);

        System.out.println("Is the first number the largest? " + isFirstLargest);
        System.out.println("Is the second number the largest? " + isSecondLargest);
        System.out.println("Is the third number the largest? " + isThirdLargest);
    }
}
