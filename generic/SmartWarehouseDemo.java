import java.util.ArrayList;
import java.util.List;

// Abstract base class
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract String getCategory();
}

// Subclasses
class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }

    public String getCategory() {
        return "Electronics";
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }

    public String getCategory() {
        return "Groceries";
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }

    public String getCategory() {
        return "Furniture";
    }
}

// Generic class
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// Utility class with wildcard method
class WarehouseUtils {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getCategory() + ": " + item.getName() + " - $" + item.getPrice());
        }
    }
}

// Main class
public class SmartWarehouseDemo {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 1500));
        electronicsStorage.addItem(new Electronics("Camera", 700));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Apple", 1.5));
        groceriesStorage.addItem(new Groceries("Milk", 2.0));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 45));
        furnitureStorage.addItem(new Furniture("Table", 100));

        System.out.println("== Electronics ==");
        WarehouseUtils.displayItems(electronicsStorage.getItems());

        System.out.println("\n== Groceries ==");
        WarehouseUtils.displayItems(groceriesStorage.getItems());

        System.out.println("\n== Furniture ==");
        WarehouseUtils.displayItems(furnitureStorage.getItems());
    }
}


