import java.util.Scanner;

public class ChocolateDivider {

    // Method returns array [chocolates per child, remaining chocolates]
    public static int[] findRemainderAndQuotient(int chocolates, int children) {
        int perChild = chocolates / children;
        int remaining = chocolates % children;
        return new int[] {perChild, remaining};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int chocolates = sc.nextInt();
        System.out.print("Enter number of children: ");
        int children = sc.nextInt();

        int[] result = findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child gets: " + result[0]);
        System.out.println("Remaining chocolates: " + result[1]);

        sc.close();
    }
}
