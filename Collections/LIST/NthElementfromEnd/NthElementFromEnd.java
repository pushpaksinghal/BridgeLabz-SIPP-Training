/**
 *
 * Find the Nth Element from the End
 * Given a singly linked list (use LinkedList), find the Nth element from the end without calculating its size.
 *
 */

package LIST.NthElementfromEnd;

import java.io.*;

class Node {
    int data;
    Node next;

    public Node (int data) {
        this.data = data;
        this.next = null;
    }
}

public class NthElementFromEnd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node head = null;
        Node tail = null;

        System.out.println("\nEnter integers for the linked list. Type -1 to end:");

        while (true) {
            int val = Integer.parseInt(br.readLine());
            if (val == -1)
                break;

            Node nn = new Node(val);
            if (head == null) {
                head = tail = nn;
            }else {
                tail.next = nn;
                tail = nn;
            }
        }

        System.out.println("\nOG Linked List :");
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL\n");


        System.out.print("\nPlease enter the position from the end of the list you'd like to display : ");
        int k = Integer.parseInt(br.readLine());

        temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                System.err.println("NUll : Value out of bounds !!");
                System.exit(0);
            }
            temp = temp.next;
        }

        Node temp2 = head;

        while (temp != null) {
            temp = temp.next;
            temp2 = temp2.next;
        }

        System.out.println("Value : " + temp2.data);
    }
}