class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskCircularLinkedList {
    private TaskNode head = null;
    private TaskNode tail = null;
    private TaskNode current = null;

    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            current = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void addAtEnd(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            current = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos == 0) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        TaskNode temp = head;
        for (int i = 0; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) tail = newNode;
    }

    public void removeById(int id) {
        if (head == null) return;

        if (head.taskId == id) {
            if (head == tail) {
                head = tail = null;
                current = null;
                return;
            }
            head = head.next;
            tail.next = head;
            if (current.taskId == id) current = head;
            return;
        }

        TaskNode prev = head, temp = head.next;
        while (temp != head && temp.taskId != id) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == head) return;

        prev.next = temp.next;
        if (temp == tail) tail = prev;
        if (current == temp) current = current.next;
    }

    public void viewCurrentTask() {
        if (current != null) {
            System.out.println("Current Task → ID: " + current.taskId + ", Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due: " + current.dueDate);
        } else {
            System.out.println("No tasks scheduled.");
        }
    }

    public void moveToNextTask() {
        if (current != null)
            current = current.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int targetPriority) {
        if (head == null) return;
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == targetPriority) {
                System.out.println("Found → Task ID: " + temp.taskId + ", Name: " + temp.taskName);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks with priority " + targetPriority);
    }
}
public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskCircularLinkedList scheduler = new TaskCircularLinkedList();

        scheduler.addAtEnd(1, "Write Report", 2, "2025-06-30");
        scheduler.addAtBeginning(2, "Team Meeting", 1, "2025-06-25");
        scheduler.addAtPosition(1, 3, "Code Review", 3, "2025-06-28");

        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        System.out.println("\nViewing current task:");
        scheduler.viewCurrentTask();

        System.out.println("\nMoving to next task:");
        scheduler.moveToNextTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearch tasks with Priority 1:");
        scheduler.searchByPriority(1);

        System.out.println("\nRemoving Task ID 3:");
        scheduler.removeById(3);
        scheduler.displayAllTasks();
    }
}
