package MAP.InvertMap;

import java.io.*;
import java.util.*;

public class InvertMap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> originalMap = new HashMap<>();

        System.out.print("Enter number of entries: ");
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key (String): ");
            String key = br.readLine();

            System.out.print("Enter value (Integer): ");
            int value = Integer.parseInt(br.readLine());

            originalMap.put(key, value);
        }

        System.out.println("\nOriginal Map:");
        System.out.println(originalMap);

        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (!invertedMap.containsKey(value)) {
                invertedMap.put(value,new ArrayList<>());
            }
            invertedMap.get(value).add(key);
        }

        System.out.println("\nInverted Map:");
        System.out.println(invertedMap);

    }
}