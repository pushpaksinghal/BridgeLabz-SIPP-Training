import java.io.*;

public class CountWord {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        String target = "Java";
        int count = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equalsIgnoreCase(target)) count++;
            }
        }

        reader.close();
        System.out.println("Occurrences: " + count);
    }
}
