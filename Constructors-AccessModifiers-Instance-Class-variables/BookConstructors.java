class Books{
	String title ;
	String Author;
	double price;
	
	Books(){
		this.Author =  null;
		this.price = 0.0;
		this.title = null;
	}
	
	Books(String title,String Author,double price){
		this.Author = Author;
		this.price = price;
		this.title = title;
	}
	
	void display() {
		System.out.println("Author: " + Author +"Wrote "+ title+ " book and it is avalaible at "+price+"$");
	}
}


public class BookConstructors{
	public static void main(String[]args) {
		Books b1 = new Books();
		Books b2 = new Books("The Notebook","Nicholas Sparks",50);
		b1.display();
		b2.display();
		
	}
}