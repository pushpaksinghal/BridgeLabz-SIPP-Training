package MAP.MergeTwoMaps;

import java.util.*;

public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 10);
        map1.put("B", 20);
        map1.put("C", 30);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 5);
        map2.put("C", 15);
        map2.put("D", 25);

        Map<String, Integer> mergedMap = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            mergedMap.put(key, mergedMap.getOrDefault(key, 0) + value);
        }

        System.out.println("\nMap 1: " + map1);
        System.out.println("\nMap 2: " + map2);
        System.out.println("\nMerged (Summed) Map: " + mergedMap);
    }
}