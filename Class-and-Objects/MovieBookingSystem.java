import java.util.Scanner;

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

    public void displayTicketDetails() {
        System.out.println("----- Ticket Details -----");
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.printf("Price      : ₹%.2f\n", price);
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieTicket ticket = new MovieTicket();

        System.out.print("Enter movie name: ");
        String movie = scanner.nextLine();

        System.out.print("Enter seat number: ");
        String seat = scanner.nextLine();

        System.out.print("Enter ticket price: ₹");
        double price = scanner.nextDouble();

        ticket.bookTicket(movie, seat, price);
        System.out.println();
        ticket.displayTicketDetails();

        scanner.close();
    }
}
