public class shoppingcartsss {
    public static void main(String[] args) {
        // Update the discount for all products
        Productss.updateDiscount(10.0); // 10% discount

        // Create product objects
        Productss p1 = new Productss("Laptop", 75000.0, 1, 101);
        Productss p2 = new Productss("Smartphone", 30000.0, 2, 102);

        // Display product details using instanceof
        Productss.displayProductDetails(p1);
        Productss.displayProductDetails(p2);

        // Test with a non-product object
        String notAProduct = "Hello";
        Productss.displayProductDetails(notAProduct);
    }
}

class Productss {
    // Static variable shared by all products
    private static double discount = 0.0; // in percentage

    // Final variable to ensure productID is immutable
    private final int productID;

    // Instance variables
    private String productName;
    private double price;
    private int quantity;

    // Constructor using 'this'
    public Productss(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    // Static method to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Updated Discount: " + discount + "%");
    }

    // Method to display product details using instanceof
    public static void displayProductDetails(Object obj) {
        if (obj instanceof Productss) {
            Productss p = (Productss) obj;
            System.out.println("\nProduct Details:");
            System.out.println("Product ID: " + p.productID);
            System.out.println("Name: " + p.productName);
            System.out.println("Price: ₹" + p.price);
            System.out.println("Quantity: " + p.quantity);
            double total = p.price * p.quantity;
            double discountedTotal = total - (total * discount / 100);
            System.out.println("Total (after " + discount + "% discount): ₹" + discountedTotal);
        } else {
            System.out.println("The object is not a Product.");
        }
    }
}
