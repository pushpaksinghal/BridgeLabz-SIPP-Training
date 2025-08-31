package LIST.ListReversal;

import java.util.Scanner;
import java.util.ArrayList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class ListReversal {
    public static Node reverseLinkedList(Node head) {
        Node newHead = null;
        while (head != null) {
            Node temp = new Node(head.data);
            temp.next = newHead;
            newHead = temp;
            head = head.next;
        }
        return newHead;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your list type: (1) ArrayList, (2) LinkedList");
        int choice = sc.nextInt();

        if (choice != 1 && choice != 2) {
            System.err.println("Invalid choice. Please enter 1 or 2.");
            System.exit(0);
        }

        System.out.print("Enter size of the list: ");
        int size = sc.nextInt();

        if (choice == 1) {
            ArrayList<Integer> list = new ArrayList<>();
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                list.add(sc.nextInt());
            }

            System.out.println("\nOG ArrayList:");
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();

            System.out.println("\nReversed ArrayList:");
            for (int i = size - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
        else {
            Node head = null, tail = null;
            System.out.println("Enter " + size + " elements:");
            for (int i = 0; i < size; i++) {
                Node newNode = new Node(sc.nextInt());
                if (head == null) {
                    head = tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }

            System.out.print("Reversed LinkedList: ");
            Node reversed = reverseLinkedList(head);
            printLinkedList(reversed);
        }
    }
}