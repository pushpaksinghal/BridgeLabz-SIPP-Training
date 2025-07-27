public class FindSentence {
    public static void main(String[] args) {
        String[] sentences = {
            "Java is powerful",
            "Python is easy",
            "C++ is fast"
        };
        String target = "easy";

        for (String sentence : sentences) {
            if (sentence.contains(target)) {
                System.out.println("Found in: " + sentence);
                return;
            }
        }
        System.out.println("Not Found");
    }
}
