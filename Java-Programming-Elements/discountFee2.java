import java.util.Scanner;

public class discountFee2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int orignalFee = sc.nextInt(); // Read the original fee from user input
        int discount = sc.nextInt();
        int discountAmount = (orignalFee * discount) / 100; // Calculate the discount amount
        int finalFee = orignalFee - discountAmount; // Calculate the final fee after discount
        System.out.println(" The discount amount is INR " + discountAmount + " and final discounted fee is INR " + finalFee);
        sc.close();
    }
}
