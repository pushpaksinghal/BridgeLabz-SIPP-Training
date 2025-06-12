import java.util.Scanner;

public class weighttopound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double wieght = sc.nextDouble();
        Double pound = wieght * 2.20462; 
        System.out.println("the wieght is "+wieght+" then in pound is "+pound);
    }
}
