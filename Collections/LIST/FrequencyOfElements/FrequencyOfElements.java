package LIST.FrequencyOfElements;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class FrequencyOfElements {
    public static void main(String[] args) {
        Map<String,Integer> freqMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no of elements you want to enter : ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];

        System.out.println("\nEnter elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
            freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0)+1);
        }

        System.out.println(freqMap);

        for (String s : freqMap.keySet()) {
            System.out.println(s + " -> " + freqMap.get(s));
        }
    }
}
