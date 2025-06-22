
import java.util.Scanner;

public class LineEquation {

    // Method to calculate Euclidean distance between two points
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to find slope and y-intercept of the line between two points
    public static double[] getLineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1); // Slope
        double b = y1 - m * x1;          // y-intercept
        return new double[]{m, b};       // return [slope, intercept]
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input two points
        System.out.print("Enter x1 and y1: ");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        
        System.out.print("Enter x2 and y2: ");
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();

        // Compute and display distance
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance = %.2f\n", distance);

        // Compute and display line equation
        if (x1 == x2) {
            System.out.println("Vertical Line: Slope is undefined.");
        } else {
            double[] result = getLineEquation(x1, y1, x2, y2);
            System.out.printf("Line Equation: y = %.2fx + %.2f\n", result[0], result[1]);
        }

        sc.close();
    }
}
