import java.util.Scanner;

public class quotietsandrimender {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double num1 = sc.nextDouble();
        Double num2 = sc.nextDouble();
        Double quotient = num1 / num2; 
        Double remainder = num1 % num2;
        System.out.println("`The quotient of " + num1 + " and " + num2 + " is " + quotient + " and the remainder is " + remainder + "`");
        sc.close();
    }
}
