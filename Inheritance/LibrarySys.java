class Bk {
    String title;
    int publicationYear;

    Bk(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Bk {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibrarySys {
    public static void main(String[] args) {
        Author book = new Author(
                "The Art of Java",
                2022,
                "John Doe",
                "John Doe is a seasoned software engineer with expertise in Java development."
        );

        book.displayInfo();
    }
}
