abstract class Work {
    private String label;

    public Work(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public abstract void execute();
}

class MailJob extends Work {
    public MailJob(String label) {
        super(label);
    }

    public void execute() {
        System.out.println("Sending email: " + getLabel());
    }
}

class ArchiveJob extends Work {
    public ArchiveJob(String label) {
        super(label);
    }

    public void execute() {
        System.out.println("Performing backup: " + getLabel());
    }
}

class Node {
    Work task;
    Node prev, next;

    public Node(Work task) {
        this.task = task;
    }
}

class TaskManager {
    private Node head, tail;

    public void insertTask(Work task) {
        Node node = new Node(task);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void insertAt(int index, Work task) {
        Node node = new Node(task);
        if (index == 0) {
            node.next = head;
            if (head != null) head.prev = node;
            head = node;
            if (tail == null) tail = node;
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            insertTask(task);
        } else {
            node.next = temp.next;
            node.prev = temp;
            temp.next.prev = node;
            temp.next = node;
        }
    }

    public void deleteTask(String label) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getLabel().equals(label)) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                else tail = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    public void runNext() {
        if (head != null) {
            head.task.execute();
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else {
            System.out.println("No tasks remaining.");
        }
    }

    public void displayTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task.getLabel());
            temp = temp.next;
        }
    }
}

public class workSA {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.insertTask(new MailJob("Client Follow-up"));
        manager.insertTask(new ArchiveJob("Server Backup"));
        manager.insertAt(1, new MailJob("Weekly Newsletter"));
        manager.displayTasks();
        manager.runNext();
        manager.deleteTask("Server Backup");
        manager.displayTasks();
    }
}
