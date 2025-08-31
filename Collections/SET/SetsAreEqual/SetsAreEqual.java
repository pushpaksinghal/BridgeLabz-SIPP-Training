package SET.SetsAreEqual;

import java.io.*;
import java.util.TreeSet;

public class SetsAreEqual {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter size of Set 1 :  ");
        int n1 = Integer.parseInt(br.readLine());

        System.out.print("\nEnter size of Set 2 :  ");
        int n2 = Integer.parseInt(br.readLine());

        TreeSet<Integer> ts1 = new TreeSet<>();
        TreeSet<Integer> ts2 = new TreeSet<>();

        System.out.println("\nEnter elements of set 1 :");
        for (int i = 0; i < n1; i++) {
            ts1.add(Integer.parseInt(br.readLine()));
        }

        System.out.println("\nEnter elements of set 2 :");
        for (int i = 0; i < n2; i++) {
            ts2.add(Integer.parseInt(br.readLine()));
        }

        if (n1 != n2) {
            System.err.println("FALSE");
        }
        else {
                if (ts1.equals(ts2)) {
                    System.out.println("\u001b[32m" + "TRUE" + "\u001b[0m");
                }
                else {
                    System.err.println("FALSE");
                }
        }
    }
}
