import java.util.Scanner;

public class celtofar {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Double celsius = sc.nextDouble();
        Double fahrenheit = (celsius * 9/5) + 32;
        System.out.println("the "+celsius+"celsius is equal to "+fahrenheit+" fahrenheit");
    }
}
