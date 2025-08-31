package QUEUE.StackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    static class Stack{
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();

            public void push(int x) {
                q2.add(x);
                while (!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
                Queue<Integer> temp = q1;
                q1 = q2;
                q2 = temp;
            }

            public int pop() {
                if (!q1.isEmpty())
                    return q1.poll();
                else
                    throw new RuntimeException("Stack is Empty !!");
            }

            public boolean isEmpty() {
                return q1.isEmpty();
            }

            public int top() {
                if (!q1.isEmpty())
                    return q1.peek();
                else
                    throw new RuntimeException("Stack is Empty !!");
            }
    }

    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(5);
        st.push(7);
        st.push(12);
        st.push(108);

        System.out.println("\nStack is empty : " + st.isEmpty());

        System.out.println("\ntop : " + st.top());

        System.out.println();
        while (!st.isEmpty()) {
            System.out.println("POP : " + st.pop());
        }

        System.out.println("\nStack is empty : " + st.isEmpty());
    }
}