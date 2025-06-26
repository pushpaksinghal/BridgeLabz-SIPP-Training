class Bookk {
    String title;
    String author;
    double price;
    boolean available;

    Bookk(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void display() {
        System.out.println(title + ", " + author + ", ₹" + price + ", Available: " + available);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Bookk b1 = new Bookk("1984", "Orwell", 299.99, true);
        b1.display();
        b1.borrowBook();
        b1.display();
        b1.borrowBook();
    }
}
