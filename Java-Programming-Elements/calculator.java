import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        float num1 = sc.nextFloat(); // Read first number
        float num2 = sc.nextFloat(); // Read second number
        Float sum = num1 + num2; // Calculate sum
        Float difference = num1 - num2; // Calculate difference
        Float product = num1 * num2; // Calculate product
        Float quotient = num1 / num2; // Calculate quotient
        System.out.println(" The addition, subtraction, multiplication and division value of 2 numbers "+num1+" and "+num2+" is "+sum+", "+difference+", "+product+", and "+quotient);
    }
}
