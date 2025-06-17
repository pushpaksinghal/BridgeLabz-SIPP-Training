import java.util.Scanner;

public class VowelConsonantChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            System.out.println(ch + " - " + getCharType(ch));
        }
    }

    public static String getCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch += 32;
        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) != -1) return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }
}
