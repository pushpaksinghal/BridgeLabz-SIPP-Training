class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode prev, next;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

class MovieDoublyLinkedList {
    private MovieNode head;
    private MovieNode tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos == 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;

        for (int i = 0; i < pos - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
    }

    public void removeByTitle(String title) {
        MovieNode current = head;

        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) return;

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void searchByDirector(String director) {
        MovieNode current = head;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.println("Title: " + current.title + ", Rating: " + current.rating);
            }
            current = current.next;
        }
    }

    public void searchByRating(double minRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.rating >= minRating) {
                System.out.println("Title: " + current.title + ", Director: " + current.director);
            }
            current = current.next;
        }
    }

    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
    }

    public void displayForward() {
        MovieNode current = head;
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.year + " | " + current.rating);
            current = current.next;
        }
    }

    public void displayReverse() {
        MovieNode current = tail;
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.year + " | " + current.rating);
            current = current.prev;
        }
    }
}

public class MovieManagementApp {
    public static void main(String[] args) {
        MovieDoublyLinkedList movies = new MovieDoublyLinkedList();

        movies.addAtEnd("Inception", "Nolan", 2010, 9.0);
        movies.addAtBeginning("Interstellar", "Nolan", 2014, 8.8);
        movies.addAtEnd("Titanic", "Cameron", 1997, 7.8);
        movies.addAtPosition(1, "Avatar", "Cameron", 2009, 8.0);

        System.out.println("Movies (Forward):");
        movies.displayForward();
        System.out.println("\nMovies (Reverse):");
        movies.displayReverse();

        System.out.println("\nSearch by Director (Nolan):");
        movies.searchByDirector("Nolan");

        System.out.println("\nSearch by Rating >= 8.5:");
        movies.searchByRating(8.5);

        System.out.println("\nUpdate Rating of 'Titanic' to 8.2");
        movies.updateRating("Titanic", 8.2);
        movies.displayForward();

        System.out.println("\nRemove 'Avatar'");
        movies.removeByTitle("Avatar");
        movies.displayForward();
    }
}
