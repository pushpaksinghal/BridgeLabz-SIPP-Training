package SET.SetToSortedList;

import java.io.*;
import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Ask for number of elements
        System.out.print("Enter number of elements for the Set : ");
        int n = Integer.parseInt(br.readLine());

        // Read user input into a HashSet
        Set<Integer> hashSet = new HashSet<>();
        System.out.println("\nEnter " + n + " integer values :");
        for (int i = 0; i < n; i++) {
            hashSet.add(Integer.parseInt(br.readLine()));
        }

        // Method 1: Convert HashSet to List and sort manually
        List<Integer> sortedList = new ArrayList<>(hashSet);
        Collections.sort(sortedList);
        System.out.println("\nSorted List (via Collections.sort()) : " + sortedList);


        // Method 2: Convert HashSet to TreeSet (automatically sorted)
        Set<Integer> treeSet = new TreeSet<>(hashSet);
        System.out.println("\nSorted Set (via TreeSet) : " + treeSet);


        // Method 3: Convert Set to Sorted Stream
        List<Integer> sortedStreamList = hashSet.stream()
                .sorted()
                .toList();
        System.out.println("\nSorted List (via Stream API): " + sortedStreamList);


        // Method 4: Using Priority Queue
        System.out.println("\nUsing Priority Queue : ");
        PriorityQueue<Integer> pq = new PriorityQueue<>(hashSet);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}