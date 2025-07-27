import java.util.*;

public class SearchComparison {

    public static boolean linearSearch(int[] arr, int target) {
        for (int val : arr) {
            if (val == target) return true;
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void runTest(int size, int target) {
        int[] data = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size * 2);
        }

        long start, end;

        start = System.nanoTime();
        boolean foundLinear = linearSearch(data, target);
        end = System.nanoTime();
        long linearTime = end - start;

        Arrays.sort(data);

        start = System.nanoTime();
        boolean foundBinary = binarySearch(data, target);
        end = System.nanoTime();
        long binaryTime = end - start;

        System.out.println("Dataset Size: " + size);
        System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
        System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
        System.out.println("Linear Found: " + foundLinear + ", Binary Found: " + foundBinary);
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        runTest(1000, 500);
        runTest(10000, 5000);
        runTest(1_000_000, 999999);
    }
}
