import java.util.*;

public class CombinedSearch {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);

        for (int i = 1; i <= n + 1; i++) {
            if (!set.contains(i)) {
                System.out.println("First missing positive: " + i);
                break;
            }
        }

        Arrays.sort(arr);
        int target = 1, left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                System.out.println("Target index: " + mid);
                return;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println("Target not found");
    }
}
