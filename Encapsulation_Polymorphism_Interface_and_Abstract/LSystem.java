interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

abstract class LibraryAsset {
    private String itemId;
    private String title;
    private String author;

    LibraryAsset(String id, String title, String author) {
        this.itemId = id;
        this.title = title;
        this.author = author;
    }

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public abstract int getLoanDuration();
}

class LibraryBook extends LibraryAsset implements Reservable {
    LibraryBook(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem() {
        System.out.println("Book reserved.");
    }

    public boolean checkAvailability() {
        return true;
    }
}

class LibraryMagazine extends LibraryAsset implements Reservable {
    LibraryMagazine(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem() {
        System.out.println("Magazine reserved.");
    }

    public boolean checkAvailability() {
        return false;
    }
}

class LibraryDVD extends LibraryAsset implements Reservable {
    LibraryDVD(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem() {
        System.out.println("DVD reserved.");
    }

    public boolean checkAvailability() {
        return true;
    }
}

public class LSystem {
    public static void main(String[] args) {
        LibraryAsset[] items = {
            new LibraryBook("B001", "Java Guide", "John Smith"),
            new LibraryMagazine("M002", "Tech Weekly", "Editor"),
            new LibraryDVD("D003", "OOP Concepts", "Jane Doe")
        };

        for (LibraryAsset item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem();
                System.out.println("Available: " + ((Reservable) item).checkAvailability());
            }
            System.out.println();
        }
    }
}
