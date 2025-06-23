import java.util.Scanner;

class Item {
    private int itemCode;
    private String itemName;
    private double price;

    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.printf("Price     : ₹%.2f\n", price);
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

public class InventoryTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Item item1 = new Item(101, "USB Drive", 499.99);

        System.out.println("Item Details:");
        item1.displayDetails();


        System.out.print("\nEnter quantity to purchase: ");
        int quantity = scanner.nextInt();


        double totalCost = item1.calculateTotalCost(quantity);
        System.out.printf("Total Cost for %d items: ₹%.2f\n", quantity, totalCost);

        scanner.close();
    }
}
