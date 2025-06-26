class Bookkk {
    public String ISBN;
    protected String title;
    private String author;

    Bookkk(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class EBook extends Bookkk {
    double fileSize;

    EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    void display() {
        System.out.println("ISBN: " + ISBN + ", Title: " + title + ", Author: " + getAuthor() + ", File Size: " + fileSize + "MB");
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        EBook ebook = new EBook("978-123456", "Java Programming", "Ramesh", 2.5);
        ebook.display();
    }
}
