package QUEUE.CircularBufferSimulation;

import java.io.*;

public class CircularBufferSimulation {
    static class CircularBuffer {
        int[] buffer;
        int size;
        int start = 0;
        int count = 0;
        int next = 0;

        public CircularBuffer(int capacity) {
            buffer = new int[capacity];
            size = capacity;
        }

        public void insert(int value) {
            buffer[next] = value;
            next = (next + 1) % size;

            if (count == size) {
                start = (start + 1) % size;
            } else {
                count++;
            }
        }

        public void display() {
            System.out.print("Buffer: [");
            int temp = start;
            for (int i = 0; i < count; i++) {
                int index = temp++ % size;
                System.out.print(buffer[index]);
                if (i < count - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter buffer size: ");
        int size = Integer.parseInt(br.readLine());

        CircularBuffer cb = new CircularBuffer(size);

        System.out.println("Enter values (type 'exit' or 'stop' to finish):");
        while (true) {
            String input = br.readLine();
            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("stop"))
                break;

            int val = Integer.parseInt(input);
            cb.insert(val);
            cb.display();
        }
    }
}