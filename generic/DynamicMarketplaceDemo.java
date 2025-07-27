interface Category {}
class BookCategory implements Category {}
class ClothingCategory implements Category {}
class GadgetCategory implements Category {}

class Product<T extends Category> {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void applyDiscount(double percentage) {
        this.price = price - (price * percentage / 100);
    }

    public String getInfo() {
        return name + " - $" + price;
    }
}

class MarketplaceApp {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Book", 500);
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 300);

        applyDiscount(book, 10);
        applyDiscount(shirt, 5);

        System.out.println(book.getInfo());
        System.out.println(shirt.getInfo());
    }
}
