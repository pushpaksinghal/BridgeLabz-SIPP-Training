import java.util.Scanner;

public class CustomStringLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int len = getLength(input);
        System.out.println("Custom Length: " + len);
        System.out.println("Built-in Length: " + input.length());
    }

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}
        return count;
    }
}
