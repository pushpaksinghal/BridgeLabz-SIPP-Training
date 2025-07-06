interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class AbstractProduct {
    private String productId;
    private String name;
    private double price;

    AbstractProduct(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayProductInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
    }
}

class ElectronicItem extends AbstractProduct implements Taxable {
    private int warrantyMonths;

    ElectronicItem(String productId, String name, double price, int warrantyMonths) {
        super(productId, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }

    @Override
    public void displayProductInfo() {
        super.displayProductInfo();
        System.out.println("Warranty: " + warrantyMonths + " months");
    }
}

class ClothingItem extends AbstractProduct implements Taxable {
    private String size;

    ClothingItem(String productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5%";
    }

    @Override
    public void displayProductInfo() {
        super.displayProductInfo();
        System.out.println("Size: " + size);
    }
}

class GroceryItem extends AbstractProduct {
    private String expiryDate;

    GroceryItem(String productId, String name, double price, String expiryDate) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    @Override
    public void displayProductInfo() {
        super.displayProductInfo();
        System.out.println("Expiry Date: " + expiryDate);
    }
}

public class ECP {
    public static void printFinalPrices(AbstractProduct[] products) {
        for (AbstractProduct product : products) {
            product.displayProductInfo();
            double discount = product.calculateDiscount();
            double tax = 0;

            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
                System.out.println(((Taxable) product).getTaxDetails());
            }

            double finalPrice = product.getPrice() + tax - discount;
            System.out.printf("Final Price: $%.2f\n", finalPrice);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AbstractProduct[] products = new AbstractProduct[3];
        products[0] = new ElectronicItem("E101", "Smartphone", 1000, 24);
        products[1] = new ClothingItem("C202", "T-Shirt", 50, "L");
        products[2] = new GroceryItem("G303", "Rice Bag", 40, "2025-12-31");

        printFinalPrices(products);
    }
}
