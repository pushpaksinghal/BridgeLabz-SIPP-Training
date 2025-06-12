import java.util.Scanner;
public class areaOFtriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float base = sc.nextFloat(); // Read base of the triangle
        float height = sc.nextFloat(); // Read height of the triangle
        float area = (base * height) / 2; // Calculate area of the triangle
        System.out.println("The area of the triangle with base " + base + " and height " + height + " is " + area);

    }
}
