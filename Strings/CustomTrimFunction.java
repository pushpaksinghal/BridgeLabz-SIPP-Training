import java.util.Scanner;

public class CustomTrimFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String custom = customTrim(input);
        System.out.println("Trimmed: '" + custom + "'");
    }

    public static String customTrim(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end && s.charAt(start) == ' ') start++;
        while (end >= start && s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) sb.append(s.charAt(i));
        return sb.toString();
    }
}
