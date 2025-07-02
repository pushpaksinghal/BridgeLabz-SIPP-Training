class Pers {
    String name;
    int age;

    Pers(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Teach extends Pers {
    String subject;

    Teach(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Role: Teacher");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }
}

class Stud extends Pers {
    String grade;

    Stud(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        System.out.println("Role: Student");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Pers {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        System.out.println("Role: Staff");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Teach teacher = new Teach("Alice", 35, "Mathematics");
        Stud student = new Stud("Bob", 16, "10th Grade");
        Staff staff = new Staff("Charlie", 40, "Administration");

        teacher.displayRole();
        teacher.displayInfo();
        System.out.println();

        student.displayRole();
        student.displayInfo();
        System.out.println();

        staff.displayRole();
        staff.displayInfo();
    }
}
