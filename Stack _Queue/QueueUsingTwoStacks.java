import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Stack<Integer> stackEnqueue = new Stack<>();
        Stack<Integer> stackDequeue = new Stack<>();

        // Enqueue operation
        stackEnqueue.push(10);
        stackEnqueue.push(20);
        stackEnqueue.push(30);

        // Dequeue operation
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        if (!stackDequeue.isEmpty()) {
            System.out.println("Dequeued: " + stackDequeue.pop()); // 10
        }

        // Peek operation
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        if (!stackDequeue.isEmpty()) {
            System.out.println("Front: " + stackDequeue.peek()); // 20
        }

        // More enqueue
        stackEnqueue.push(40);

        // Dequeue again
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        if (!stackDequeue.isEmpty()) {
            System.out.println("Dequeued: " + stackDequeue.pop()); // 20
        }

        // Dequeue remaining
        while (!stackDequeue.isEmpty() || !stackEnqueue.isEmpty()) {
            if (stackDequeue.isEmpty()) {
                while (!stackEnqueue.isEmpty()) {
                    stackDequeue.push(stackEnqueue.pop());
                }
            }
            System.out.println("Dequeued: " + stackDequeue.pop());
        }
    }
}
