class Book{
	String author;
	double price;
	
	Book(String author, double price){
		this.author = author;
		this.price = price;
		
	}
	
	void showBookDetails(){
		System.out.println("This book was written by " + author+ " it is avalaible for" + price+" $");
	}
}


public class BookDetails{
	public static void main(String[]args) {
		Book b1 = new Book("J.K.Rowling",49.99);
		b1.showBookDetails();
	}
}