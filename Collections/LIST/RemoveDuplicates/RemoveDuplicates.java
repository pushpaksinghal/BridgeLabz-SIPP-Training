/**
 *
 * Remove Duplicates While Preserving Order
 *
 */

package LIST.RemoveDuplicates;

import java.io.*;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter size of Array : ");
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        System.out.println("\nEnter elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> linkedSet = new LinkedHashSet<>(
                Arrays.stream(arr).boxed().toList()
        );

        System.out.println("Using Linked HashSet :");
        System.out.println(linkedSet);

//-------------------------------------------------------------------------

        List<Integer> distinctList = Arrays.stream(arr)
                .boxed()
                .distinct()
                .toList();

        System.out.println("Using Stream.distinct() :");
        System.out.println(distinctList);


//-------------------------------------------------------------------------

        System.out.println("Using Arrays and HashSet :");

        Set<Integer> seen = new HashSet<>();
        System.out.print("[");

        boolean comma = true;
        for (int i : arr) {
            if (!seen.contains(i)) {
                if (!comma) System.out.print(", ");
                System.out.print(i);
                seen.add(i);
                comma = false;
            }
        }
        System.out.println("]");

    }
}


