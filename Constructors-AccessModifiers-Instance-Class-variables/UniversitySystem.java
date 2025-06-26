class Studentss {
    public int rollNumber;
    protected String name;
    private double CGPA;

    Studentss(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }
}

class PostgraduateStudent extends Studentss {
    String specialization;

    PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    void display() {
        System.out.println("Roll: " + rollNumber + ", Name: " + name + ", CGPA: " + getCGPA() + ", Specialization: " + specialization);
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        PostgraduateStudent pgs = new PostgraduateStudent(101, "Anita", 8.5, "AI");
        pgs.display();
    }
}
