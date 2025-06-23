class Student {
    String name;
    int rollNumber;
    double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public void displayDetails() {
        System.out.println("Name       : " + name);
        System.out.println("Roll No.   : " + rollNumber);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + calculateGrade());
    }
}

public class StudentReport {
    public static void main(String[] args) {
        Student student1 = new Student("Aryan Sharma", 101, 88.5);
        Student student2 = new Student("Meera Joshi", 102, 72.0);
        Student student3 = new Student("Kunal Mehta", 103, 55.5);

        System.out.println("Student 1 Report:");
        student1.displayDetails();

        System.out.println("\nStudent 2 Report:");
        student2.displayDetails();

        System.out.println("\nStudent 3 Report:");
        student3.displayDetails();
    }
}
