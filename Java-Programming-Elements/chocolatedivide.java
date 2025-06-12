import java.util.Scanner;

public class chocolatedivide {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int totalChocolates = sc.nextInt(); // Total number of chocolates
        int children = sc.nextInt(); // Number of children
        int chocolatesPerChild = totalChocolates / children; // Chocolates each child gets
        int remainingChocolates = totalChocolates % children; // Remaining chocolates after division
        System.out.println("The Chocolates Per Child is "+ chocolatesPerChild+" and the remaining chocolates not distributed is " + remainingChocolates);
    }
}
