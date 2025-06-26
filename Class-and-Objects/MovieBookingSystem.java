import java.util.*;

class MovieTicket {
    String movieName;
    String seatNumber;
    double price;

    public void bookTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully.");
    }
}

class cinema{
	ArrayList<MovieTicket> movies = new ArrayList<>();
	
	public void addSoldSeat(MovieTicket movie) {
		movies.add(movie);
	}
	
	public void removiesoldseat( String movieName) {
		for(int i=0;i<movies.size();i++) {
			if(movies.get(i).movieName.equals(movieName)) {
				movies.remove(i);
			}
		}
	}
	
	public void displaysoldseats() {
		for(int i=0;i<movies.size();i++) {
			System.out.println("MovieName: "+ movies.get(i).movieName);
			System.out.println("SeatNumber: "+ movies.get(i).seatNumber);
			System.out.println("Price: "+ movies.get(i).price);
			System.out.println();
		}
	}
	
}
public class MovieBookingSystem {
    public static void main(String[] args) {
        cinema c1 = new cinema();
        MovieTicket ticket1 = new MovieTicket();
        MovieTicket ticket2 = new MovieTicket();
        ticket1.bookTicket("spiderman", "004", 100.00);
        ticket2.bookTicket("SUPERMAN", "104", 70.00);
        
        c1.addSoldSeat(ticket1);
        c1.addSoldSeat(ticket2);
        c1.displaysoldseats();
     
    }
}
