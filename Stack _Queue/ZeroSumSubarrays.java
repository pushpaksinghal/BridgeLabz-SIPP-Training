import java.util.*;

public class ZeroSumSubarrays {
    public static int countZeroSumSubarrays(int[] arr) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int count = 0, sum = 0;
        sumMap.put(0, 1);

        for (int num : arr) {
            sum += num;
            count += sumMap.getOrDefault(sum, 0);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
