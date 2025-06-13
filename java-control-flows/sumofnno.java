import java.util.Scanner;
public class sumofnno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("Please enter a natural number greater than 0.");
            return;
        }

        int formulaSum = n * (n + 1) / 2;

        int loopSum = 0;
        int i = 1;
        while (i <= n) {
            loopSum += i;
            i++;
        }
        if (formulaSum == loopSum) {
            System.out.println("Both computations are correct.");
        } else {
            System.out.println("There is an error in the computations.");
        }
    }
    
}
