public class discountFee {
    public static void main(String[] args) {
        int orignalFee = 125000;
        int discount = 10;
        int discountAmount = (orignalFee * discount) / 100; // Calculate the discount amount
        int finalFee = orignalFee - discountAmount; // Calculate the final fee after discount
        System.out.println(" The discount amount is INR " + discountAmount + " and final discounted fee is INR " + finalFee);
    }
}
