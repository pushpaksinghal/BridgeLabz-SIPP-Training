import java.util.*;

class Courseee {
    private String name;
    private Professor professor;
    private List<Studentess> enrolledStudents;

    public Courseee(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.addCourse(this);
        System.out.println("Professor " + professor.getName() + " assigned to course " + name);
    }

    public void enrollStudent(Studentess student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this);
            System.out.println("Student " + student.getName() + " enrolled in course " + name);
        }
    }

    public void showDetails() {
        System.out.println("Course: " + name);
        if (professor != null) {
            System.out.println("Taught by: " + professor.getName());
        }
        System.out.println("Enrolled Students:");
        for (Studentess s : enrolledStudents) {
            System.out.println(" - " + s.getName());
        }
    }
}

class Professor {
    private String name;
    private List<Courseee> teachingCourses;

    public Professor(String name) {
        this.name = name;
        this.teachingCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Courseee course) {
        if (!teachingCourses.contains(course)) {
            teachingCourses.add(course);
        }
    }

    public void showCourses() {
        System.out.println("Courses taught by Professor " + name + ":");
        for (Courseee c : teachingCourses) {
            System.out.println(" - " + c.getName());
        }
    }
}

class Studentess {
    private String name;
    private List<Courseee> enrolledCourses;

    public Studentess(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Courseee course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
    }

    public void showCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Courseee c : enrolledCourses) {
            System.out.println(" - " + c.getName());
        }
    }
}

public class universitymanagement {
    public static void main(String[] args) {
        Studentess s1 = new Studentess("Ravi");
        Studentess s2 = new Studentess("Priya");

        Professor p1 = new Professor("Dr. Mehta");
        Professor p2 = new Professor("Dr. Kapoor");

        Courseee c1 = new Courseee("Data Structures");
        Courseee c2 = new Courseee("Operating Systems");

        c1.assignProfessor(p1);
        c2.assignProfessor(p2);

        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c2.enrollStudent(s2);

        s1.showCourses();
        s2.showCourses();

        p1.showCourses();
        p2.showCourses();

        c1.showDetails();
        c2.showDetails();
    }
}
