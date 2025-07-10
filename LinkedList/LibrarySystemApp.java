class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode prev, next;

    BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

class LibraryDoublyLinkedList {
    private BookNode head = null;
    private BookNode tail = null;

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean available) {
        BookNode newNode = new BookNode(title, author, genre, bookId, available);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addAtEnd(String title, String author, String genre, int bookId, boolean available) {
        BookNode newNode = new BookNode(title, author, genre, bookId, available);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addAtPosition(int pos, String title, String author, String genre, int bookId, boolean available) {
        if (pos == 0) {
            addAtBeginning(title, author, genre, bookId, available);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, bookId, available);
        BookNode current = head;
        for (int i = 0; i < pos - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            addAtEnd(title, author, genre, bookId, available);
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
    }

    public void removeByBookId(int bookId) {
        BookNode current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }
        if (current == null) return;

        if (current == head) {
            head = current.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void updateAvailability(int bookId, boolean newStatus) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = newStatus;
                return;
            }
            current = current.next;
        }
    }

    public void searchByTitleOrAuthor(String query) {
        BookNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(query) || current.author.equalsIgnoreCase(query)) {
                System.out.println("Book: " + current.title + " | Author: " + current.author + " | ID: " + current.bookId + " | Available: " + current.isAvailable);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No book found for query: " + query);
    }

    public void displayForward() {
        BookNode current = head;
        while (current != null) {
            System.out.println(current.title + " | " + current.author + " | " + current.genre + " | ID: " + current.bookId + " | Available: " + current.isAvailable);
            current = current.next;
        }
    }

    public void displayReverse() {
        BookNode current = tail;
        while (current != null) {
            System.out.println(current.title + " | " + current.author + " | " + current.genre + " | ID: " + current.bookId + " | Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
public class LibrarySystemApp {
    public static void main(String[] args) {
        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

        library.addAtEnd("The Alchemist", "Paulo Coelho", "Fiction", 1001, true);
        library.addAtBeginning("1984", "George Orwell", "Dystopian", 1002, true);
        library.addAtPosition(1, "The Hobbit", "Tolkien", "Fantasy", 1003, false);

        System.out.println("Books (Forward):");
        library.displayForward();

        System.out.println("\nBooks (Reverse):");
        library.displayReverse();

        System.out.println("\nUpdating availability of Book ID 1003:");
        library.updateAvailability(1003, true);
        library.displayForward();

        System.out.println("\nSearching for 'Orwell':");
        library.searchByTitleOrAuthor("Orwell");

        System.out.println("\nRemoving Book ID 1001:");
        library.removeByBookId(1001);
        library.displayForward();

        System.out.println("\nTotal Books: " + library.countBooks());
    }
}
