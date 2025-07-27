
	class myqqq {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;

    public	myqqq() {
        this.front = this.rear = null;
    }

    public void enQueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            System.out.println(data + " enqueued into the queue.");
            return;
        }

        rear.next = newNode;
        rear = newNode;
        System.out.println(data + " enqueued");
    }

    public int deQueue() {
        if (front == null) {
            System.out.println(" Can't dequeue.");
            return -1;
        }

        int removedData = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        System.out.println(removedData + " dequeued from the queue.");
        return removedData;
    }

    public void display() {
        if (front == null) {
            System.out.println("empty.");
            return;
        }

        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public boolean isEmpty() {
        return front == null;
    }
    
}
public class qqqqqq{
    public static void Main(String[] args) {
       	myqqq queue = new	myqqq();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.display();
        queue.deQueue();
        queue.display();
    }
}