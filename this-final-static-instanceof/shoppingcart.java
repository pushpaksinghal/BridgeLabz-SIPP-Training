public class shoppingcart {
    public static void main(String[] args) {
        // Update the discount for all products
        Product.updateDiscount(10.0); // 10% discount

        // Create product objects
        Product p1 = new Product("Laptop", 75000.0, 1, 101);
        Product p2 = new Product("Smartphone", 30000.0, 2, 102);

        // Display product details using instanceof
        Product.displayProductDetails(p1);
        Product.displayProductDetails(p2);

        // Test with a non-product object
        String notAProduct = "Hello";
        Product.displayProductDetails(notAProduct);
    }
}

class Product {
    // Static variable shared by all products
    private static double discount = 0.0; // in percentage

    // Final variable to ensure productID is immutable
    private final int productID;

    // Instance variables
    private String productName;
    private double price;
    private int quantity;

    // Constructor using 'this'
    public Product(String productName, double price, int quantity, int productID) {
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
        if (obj instanceof Product) {
            Product p = (Product) obj;
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
