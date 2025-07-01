import java.util.*;

class bookss{
	private String author;
	private String title;
	
	bookss(String author, String title){
		this.author = author;
		this.title = title;
	}
	
	public String getauthor() {
		return author;
	}
	public String gettitle() {
		return title;
	}
}

class library{
	ArrayList<bookss> currentbooks = new ArrayList<>();
	
	library(){
		this.currentbooks = new ArrayList<>();
	}
	
	public void addBooks(bookss book) {
		currentbooks.add(book);
		System.out.println(book.gettitle() +"has been added in the library");
	}
	public void showallbooks() {
		for(bookss book:currentbooks) {
			System.out.println(book.gettitle() +" by "+book.getauthor());
		}
	}
}

public class libraryandBooks{
	public static void main(String[]args) {
		bookss b1 = new bookss("j.k.rowling","harry potter and the goblet of fire");
		bookss b2 = new bookss("andy","project hail mary");
		
		library l1 = new library();
		l1.addBooks(b1);
		l1.addBooks(b2);
		
		l1.showallbooks();
	}
}