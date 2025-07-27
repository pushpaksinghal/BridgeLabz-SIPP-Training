import java.util.Arrays;
import java.util.Random;

public class SearchComparison2 {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return i;
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1_000_000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] data = rand.ints(size, 1, size * 2).toArray();
            int target = data[size / 2]; // likely to be found

            long startLinear = System.nanoTime();
            linearSearch(data, target);
            long endLinear = System.nanoTime();

            Arrays.sort(data); // Required for Binary Search
            long startBinary = System.nanoTime();
            binarySearch(data, target);
            long endBinary = System.nanoTime();

            System.out.println("Dataset size: " + size);
            System.out.println("Linear Search: " + (endLinear - startLinear) / 1_000_000.0 + " ms");
            System.out.println("Binary Search: " + (endBinary - startBinary) / 1_000_000.0 + " ms");
            System.out.println("--------------------------------------------------");
        }
    }
}
