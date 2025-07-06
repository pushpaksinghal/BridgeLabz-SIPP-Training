class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private StudentNode head;

    public void addAtBeginning(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int roll, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode current = head;
        while (current.next != null)
            current = current.next;
        current.next = newNode;
    }

    public void addAtPosition(int position, int roll, String name, int age, String grade) {
        if (position == 0) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        StudentNode newNode = new StudentNode(roll, name, age, grade);
        StudentNode current = head;
        for (int i = 0; i < position - 1 && current != null; i++)
            current = current.next;

        if (current == null) return;

        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteByRoll(int roll) {
        if (head == null) return;

        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }

        StudentNode current = head;
        while (current.next != null && current.next.rollNumber != roll)
            current = current.next;

        if (current.next != null)
            current.next = current.next.next;
    }

    public StudentNode searchByRoll(int roll) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == roll)
                return current;
            current = current.next;
        }
        return null;
    }

    public void updateGrade(int roll, String newGrade) {
        StudentNode student = searchByRoll(roll);
        if (student != null) {
            student.grade = newGrade;
        }
    }

    public void displayAll() {
        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll: " + current.rollNumber + ", Name: " + current.name +
                    ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
}

public class StudentRecordSystem {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtEnd(101, "Alice", 20, "A");
        list.addAtBeginning(102, "Bob", 21, "B");
        list.addAtPosition(1, 103, "Charlie", 19, "A+");

        list.displayAll();
        System.out.println();

        list.updateGrade(101, "A+");
        list.deleteByRoll(102);

        System.out.println("After update and delete:");
        list.displayAll();

        System.out.println();
        StudentNode found = list.searchByRoll(103);
        if (found != null)
            System.out.println("Found: " + found.name + ", Grade: " + found.grade);
    }
}
