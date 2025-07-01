import java.util.*;

class School {
    private String name;
    private List<Studenstss> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Studenstss student) {
        students.add(student);
    }

    public void showAllStudents() {
        System.out.println("Students in " + name + ":");
        for (Studenstss s : students) {
            System.out.println(" " + s.getName());
        }
    }
}

class Studenstss {
    private String name;
    private List<Coursess> courses;

    public Studenstss(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Coursess course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    public void viewCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Coursess c : courses) {
            System.out.println(" " + c.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Coursess {
    private String name;
    private List<Studenstss> students;

    public Coursess(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Studenstss student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void viewEnrolledStudents() {
        System.out.println("Students enrolled in " + name + ":");
        for (Studenstss s : students) {
            System.out.println(" " + s.getName());
        }
    }

    public String getName() {
        return name;
    }
}

public class schoolandstudentwithcourse {
    public static void main(String[] args) {
        School school = new School("Green Valley School");

        Studenstss alice = new Studenstss("Alice");
        Studenstss bob = new Studenstss("Bob");

        Coursess math = new Coursess("Mathematics");
        Coursess science = new Coursess("Science");

        school.addStudent(alice);
        school.addStudent(bob);

        alice.enrollInCourse(math);
        alice.enrollInCourse(science);
        bob.enrollInCourse(science);

        alice.viewCourses();
        bob.viewCourses();

        math.viewEnrolledStudents();
        science.viewEnrolledStudents();

        school.showAllStudents();
    }
}
