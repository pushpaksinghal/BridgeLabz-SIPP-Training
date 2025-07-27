import java.util.List;

abstract class CourseType {
    public abstract String getTypeName();
}

class ExamCourse extends CourseType {
    public String getTypeName() {
        return "Exam Based";
    }
}

class AssignmentCourse extends CourseType {
    public String getTypeName() {
        return "Assignment Based";
    }
}

class ResearchCourse extends CourseType {
    public String getTypeName() {
        return "Research Based";
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T type;

    public Course(String courseName, T type) {
        this.courseName = courseName;
        this.type = type;
    }

    public void displayCourseInfo() {
        System.out.println(courseName + " - " + type.getTypeName());
    }
}

class CourseSystem {
    public static void displayAllCourses(List<? extends CourseType> types) {
        for (CourseType type : types) {
            System.out.println(type.getTypeName());
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>("Math 101", new ExamCourse());
        Course<ResearchCourse> ai = new Course<>("AI Research", new ResearchCourse());

        math.displayCourseInfo();
        ai.displayCourseInfo();
    }
}
