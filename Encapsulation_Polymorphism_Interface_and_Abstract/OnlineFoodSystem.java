interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

abstract class FoodOrderItem {
    private String itemName;
    private double price;
    private int quantity;

    FoodOrderItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void displayDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

class VegMealItem extends FoodOrderItem implements Discountable {
    private double discount;

    VegMealItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public void applyDiscount(double percent) {
        discount = (getPrice() * percent) / 100;
    }

    public String getDiscountDetails() {
        return "Veg Discount Applied: $" + discount;
    }

    public double calculateTotalPrice() {
        return (getPrice() - discount) * getQuantity();
    }
}

class NonVegMealItem extends FoodOrderItem implements Discountable {
    private double discount;
    private final double nonVegCharge = 20;

    NonVegMealItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public void applyDiscount(double percent) {
        discount = (getPrice() * percent) / 100;
    }

    public String getDiscountDetails() {
        return "Non-Veg Discount Applied: $" + discount;
    }

    public double calculateTotalPrice() {
        return (getPrice() + nonVegCharge - discount) * getQuantity();
    }
}

public class OnlineFoodSystem {
    public static void main(String[] args) {
        FoodOrderItem[] order = new FoodOrderItem[2];

        VegMealItem veg = new VegMealItem("Paneer Biryani", 150, 2);
        veg.applyDiscount(10);

        NonVegMealItem nonVeg = new NonVegMealItem("Chicken Biryani", 200, 1);
        nonVeg.applyDiscount(5);

        order[0] = veg;
        order[1] = nonVeg;

        for (FoodOrderItem item : order) {
            item.displayDetails();
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                System.out.println(d.getDiscountDetails());
            }
            System.out.println("Total Price: $" + item.calculateTotalPrice());
            System.out.println();
        }
    }
}
