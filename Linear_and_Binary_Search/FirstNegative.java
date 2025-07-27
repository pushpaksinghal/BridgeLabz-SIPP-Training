public class FirstNegative {
    public static void main(String[] args) {
        int[] arr = {4, 5, -2, 8, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                System.out.println("First negative at index: " + i);
                return;
            }
        }
        System.out.println("-1");
    }
}
