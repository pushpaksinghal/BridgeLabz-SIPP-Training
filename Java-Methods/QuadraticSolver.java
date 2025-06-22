
import java.util.Scanner;

public class QuadraticSolver {

    // Method to find the roots of a quadratic equation
    public static double[] findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[0]; // no real roots
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter coefficients a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double[] roots = findRoots(a, b, c);
        if (roots.length == 2)
            System.out.printf("Two real roots: %.2f and %.2f\n", roots[0], roots[1]);
        else if (roots.length == 1)
            System.out.printf("One real root: %.2f\n", roots[0]);
        else
            System.out.println("No real roots.");

        sc.close();
    }
}
