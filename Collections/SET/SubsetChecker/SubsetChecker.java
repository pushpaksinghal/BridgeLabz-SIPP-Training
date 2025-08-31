package SET.SubsetChecker;

import java.io.*;
import java.util.*;

public class SubsetChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter size of Set 1: ");
        int n1 = Integer.parseInt(br.readLine());

        System.out.print("\nEnter size of Set 2: ");
        int n2 = Integer.parseInt(br.readLine());

        System.out.println("\nEnter elements of Set 1:");
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            set1.add(Integer.parseInt(br.readLine()));
        }

        System.out.println("\nEnter elements of Set 2:");
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n2; i++) {
            set2.add(Integer.parseInt(br.readLine()));
        }

        final String GREEN = "\u001B[32m";
        final String BLUE = "\u001B[34m";
        final String RED = "\u001B[31m";
        final String RESET = "\u001B[0m";

        boolean isSubset = set2.containsAll(set1);

        if (isSubset) {
            System.out.println(BLUE + "\nSet1 is a subset of Set2 : " + GREEN + "true" + RESET);
        } else {
            System.out.println(BLUE + "\nSet1 is a subset of Set2 : " + RED + "false" + RESET);
        }
    }
}
