
import java.util.Arrays;

public class NumberChecker {
    
	//Method for counting the digit in number
    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    //method for making array which contain digit of number
    public static int[] getDigits(int num) {
        String str = String.valueOf(num);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++)
            digits[i] = str.charAt(i) - '0';
        return digits;
    }

    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++)
            reversed[i] = digits[digits.length - 1 - i];
        return reversed;
    }
    
	//Methods for checking arrays are equal or not
    public static boolean areArraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }
    
	//Method for checking is number is palindrome or not
    public static boolean isPalindrome(int num) {
        int[] digits = getDigits(num);
        int[] reversed = reverseDigits(digits);
        return areArraysEqual(digits, reversed);
    }
    
	//Method for checking is the number is duck number or not
    public static boolean isDuckNumber(int num) {
        String str = String.valueOf(num);
        return str.indexOf('0') > 0;
    }

    public static void main(String[] args) {
        int number = 12321;
        System.out.println("Is Palindrome: " + isPalindrome(number));
        System.out.println("Is Duck Number: " + isDuckNumber(number));
    }
}
