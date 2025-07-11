public class ReverseString {

    public static String reverseUsingStringBuilder(String input) {
        // Create a StringBuilder object and append the input string
        StringBuilder sb = new StringBuilder(input);
        
        // Use the reverse() method
        sb.reverse();
        
        // Convert back to string and return
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverseUsingStringBuilder(input);
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
