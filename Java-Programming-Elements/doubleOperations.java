import java.util.Scanner;

public class doubleOperations {
    public static void main(String[] args) {
        //a + b *c, a * b + c, c + a / b, and a % b + c.
        Scanner sc = new Scanner(System.in);
        Double b = sc.nextDouble();
        Double c = sc.nextDouble();
        Double a = sc.nextDouble();
        Double result1 = a + b * c;
        Double result2 = a * b + c;
        Double result3 = c + a / b;
        Double result4 = a % b + c;
        System.out.println("a + b * c = " + result1 +", a * b + c = " + result2 + ", c + a / b = " + result3 + ", a % b + c = " + result4);
    }
}
