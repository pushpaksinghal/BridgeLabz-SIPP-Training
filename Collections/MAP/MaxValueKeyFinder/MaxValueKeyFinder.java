package MAP.MaxValueKeyFinder;

import java.io.*;
import java.util.*;

public class MaxValueKeyFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter number of entries: ");
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key (String): ");
            String key = br.readLine();

            System.out.print("Enter value (Integer): ");
            int value = Integer.parseInt(br.readLine());

            map.put(key, value);
        }

        String key = null;
        int max = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }

        System.out.println(map);
        System.out.println("\nKey with highest value : " + key);
        System.out.println("\nHighest value : " + max);
    }
}
