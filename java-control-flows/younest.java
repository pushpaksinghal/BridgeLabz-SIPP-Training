import java.util.Scanner;

public class younest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age1 = sc.nextInt(), height1 = sc.nextInt();
        int age2 = sc.nextInt(), height2 = sc.nextInt();
        int age3 = sc.nextInt(), height3 = sc.nextInt();
        String youngest, tallest;
        if (age1 < age2 && age1 < age3) youngest = "Amar";
        else if (age2 < age1 && age2 < age3) youngest = "Akbar";
        else youngest = "Anthony";
        if (height1 > height2 && height1 > height3) tallest = "Amar";
        else if (height2 > height1 && height2 > height3) tallest = "Akbar";
        else tallest = "Anthony";
        System.out.println("Youngest: " + youngest);
        System.out.println("Tallest: " + tallest);
    }
}
