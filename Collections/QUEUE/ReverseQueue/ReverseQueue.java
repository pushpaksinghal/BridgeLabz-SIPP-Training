package QUEUE.ReverseQueue;

import java.io.*;
import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        System.out.print("\nEnter number of elements in the queue: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("\nEnter " + n + " integer values:");
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        System.out.println("\nOriginal Queue: " + q);
        reverse(q);
        System.out.println("\nReversed Queue: " + q);
    }

    public static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) return;

        int front = q.remove();
        reverse(q);
        q.add(front);
    }
}