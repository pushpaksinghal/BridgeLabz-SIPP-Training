import java.util.Scanner;

public class lotsOfhandshake {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt(); 
        int totalhankshakes = (n*(n-1))/2;
        System.out.println("Total number of handshakes is " + totalhankshakes);
        sc.close();
    }
}
