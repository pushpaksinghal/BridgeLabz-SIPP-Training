class Cor {
    String courseName;
    int duration;

    Cor(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Cor {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

public class CourseHierarchy {
    public static void main(String[] args) {
        Cor basicCourse = new Cor("Java Basics", 20);
        OnlineCourse online = new OnlineCourse("Web Development", 40, "Udemy", true);
        PaidOnlineCourse paid = new PaidOnlineCourse("Data Science", 60, "Coursera", true, 500, 10);

        basicCourse.displayInfo();
        System.out.println();

        online.displayInfo();
        System.out.println();

        paid.displayInfo();
    }
}
