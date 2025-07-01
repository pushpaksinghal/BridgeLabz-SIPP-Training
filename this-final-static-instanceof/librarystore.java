public class librarystore {
    public static void main(String[] args) {
        // Display the static library name
        Booka.displayLibraryName();

        // Create Book objects
        Booka book1 = new Booka("The Alchemist", "Paulo Coelho", "9780061122415");
        Booka book2 = new Booka("1984", "George Orwell", "9780451524935");

        // Display book details using instanceof
        Booka.displayBookDetails(book1);
        Booka.displayBookDetails(book2);

        // Test with a non-Book object
        String notABook = "Just a string";
        Booka.displayBookDetails(notABook);
    }
}

class Booka {
    // Static variable shared across all books
    public static String libraryName = "City Central Library";

    // Final variable to ensure ISBN cannot be changed
    private final String isbn;

    // Instance variables
    private String title;
    private String author;

    // Constructor using 'this'
    public Booka(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details if object is an instance of Book
    public static void displayBookDetails(Object obj) {
        if (obj instanceof Booka) {
            Booka book = (Booka) obj;
            System.out.println("\nBook Details:");
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("ISBN: " + book.isbn);
        } else {
            System.out.println("The object is not a Book.");
        }
    }
}
