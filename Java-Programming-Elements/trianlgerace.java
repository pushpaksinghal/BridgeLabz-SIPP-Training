import java.util.Scanner;

public class trianlgerace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double side1 = sc.nextDouble();
        Double side2 = sc.nextDouble();
        Double side3 = sc.nextDouble();

        Double rounds = (side1+side2+side3)/3;
        System.out.println("the athlete can run "+rounds+"in 5km of run");
    }
}
