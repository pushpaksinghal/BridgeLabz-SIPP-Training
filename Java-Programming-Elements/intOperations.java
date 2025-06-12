import java.util.Scanner;

public class intOperations {
    public static void main(String[] args) {
        //a + b *c, a * b + c, c + a / b, and a % b + c.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;
        System.out.println("a + b * c = " + result1 +", a * b + c = " + result2 + ", c + a / b = " + result3 + ", a % b + c = " + result4);
    }
}
