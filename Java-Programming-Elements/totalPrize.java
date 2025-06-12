import java.util.Scanner;

public class totalPrize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double unitprice =sc.nextDouble();
        Double quantity = sc.nextDouble();
        Double total = unitprice * quantity; // Calculate total prize
        System.out.println("The total prize is " + total + " for unit price " + unitprice + " and quantity " + quantity);
    }
}
