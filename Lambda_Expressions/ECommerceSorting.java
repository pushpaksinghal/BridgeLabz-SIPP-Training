package Lambda_Expressions;
import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("%s - ₹%.2f - %.1f★ - %.0f%% off",
                name, price, rating, discount);
    }
}

public class ECommerceSorting {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 55000, 4.5, 10));
        products.add(new Product("Phone", 30000, 4.7, 15));
        products.add(new Product("Headphones", 2000, 4.2, 25));
        products.add(new Product("Smartwatch", 8000, 4.0, 20));

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Choose Sorting Criteria ===");
        System.out.println("1. By Price (Low to High)");
        System.out.println("2. By Rating (High to Low)");
        System.out.println("3. By Discount (High to Low)");
        System.out.print("Choice: ");
        int choice = sc.nextInt();

        // Dynamic sorting using lambdas
        switch (choice) {
            case 1:
                products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
                break;
            case 2:
                products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
                break;
            case 3:
                products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
                break;
            default:
                System.out.println("Invalid choice. Showing unsorted products.");
        }

        // Display sorted list
        System.out.println("\n=== Sorted Products ===");
        products.forEach(System.out::println);

        sc.close();
    }
}
