import java.util.Scanner;

public class findSideoFSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Float perameter = sc.nextFloat();
        Float side = perameter / 4; // Calculate the side of the square
        System.out.println("The length of the side is  " + side + " whose perimeter is " + perameter);
    }
}
