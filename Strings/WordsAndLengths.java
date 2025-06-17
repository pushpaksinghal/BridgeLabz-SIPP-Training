import java.util.Scanner;

public class WordsAndLengths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = text.split(" ");
        for (String word : words) {
            System.out.println(word + " - " + word.length());
        }
    }
}
