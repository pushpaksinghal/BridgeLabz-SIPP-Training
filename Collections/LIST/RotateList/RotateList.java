package LIST.RotateList;

import java.util.*;
import java.io.*;

public class RotateList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter size of Array : ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("\nEnter elements of the array.");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print("\nEnter number by which you want to rotate the array : ");
        int k = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>(
                Arrays.stream(arr).boxed().toList()
        );

        System.out.print("\nOG List : ");
        System.out.println(list);

        RotateArray(list,k);

        System.out.print("\nRotated List : ");
        System.out.println(list);

    }

    private static void RotateArray(List<Integer> list, int k) {
        int n = list.size();
        if (n == 0) return;

        k = k % n;

        List<Integer> head = new ArrayList<>(list.subList(0,k));
        List<Integer> tail = new ArrayList<>(list.subList(k,n));

        list.clear();
        list.addAll(tail);
        list.addAll(head);
    }
}
