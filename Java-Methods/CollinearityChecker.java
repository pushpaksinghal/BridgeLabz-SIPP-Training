import java.util.Scanner;

public class CollinearityChecker {

    // Method to check collinearity using slope
    public static boolean isCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }

    // Method to check collinearity using area of triangle
    public static boolean isCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking coordinates of 3 points
        System.out.println("Enter coordinates of 3 points:");
        System.out.print("x1 y1: ");
        int x1 = sc.nextInt(), y1 = sc.nextInt();
        System.out.print("x2 y2: ");
        int x2 = sc.nextInt(), y2 = sc.nextInt();
        System.out.print("x3 y3: ");
        int x3 = sc.nextInt(), y3 = sc.nextInt();

        // Check collinearity using both methods
        boolean slopeMethod = isCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areaMethod = isCollinearByArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Using slope method: " + (slopeMethod ? "Collinear" : "Not Collinear"));
        System.out.println("Using area method: " + (areaMethod ? "Collinear" : "Not Collinear"));

        sc.close();
    }
}
