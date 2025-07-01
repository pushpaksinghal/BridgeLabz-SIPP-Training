import java.util.*;

class University {
    private String name;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void assignFacultyToDepartment(String departmentName, Faculty faculty) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                dept.addFaculty(faculty);
                return;
            }
        }
    }

    public void showStructure() {
        System.out.println("University: " + name);
        for (Department dept : departments) {
            System.out.println(" Department: " + dept.getName());
            dept.showFaculties();
        }

        System.out.println("Independent Faculties:");
        for (Faculty f : faculties) {
            if (!isFacultyInAnyDepartment(f)) {
                System.out.println(" " + f.getName());
            }
        }
    }

    private boolean isFacultyInAnyDepartment(Faculty faculty) {
        for (Department dept : departments) {
            if (dept.hasFaculty(faculty)) {
                return true;
            }
        }
        return false;
    }

    private class Department {
        private String name;
        private List<Faculty> facultyList;

        public Department(String name) {
            this.name = name;
            this.facultyList = new ArrayList<>();
        }

        public void addFaculty(Faculty faculty) {
            if (!facultyList.contains(faculty)) {
                facultyList.add(faculty);
            }
        }

        public String getName() {
            return name;
        }

        public void showFaculties() {
            for (Faculty f : facultyList) {
                System.out.println("  Faculty: " + f.getName());
            }
        }

        public boolean hasFaculty(Faculty faculty) {
            return facultyList.contains(faculty);
        }
    }
}

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class universitywithfacultiesanddeparment {
    public static void main(String[] args) {
        Faculty f1 = new Faculty("Dr. Smith");
        Faculty f2 = new Faculty("Dr. Johnson");
        Faculty f3 = new Faculty("Dr. Watson");

        University university = new University("Global University");

        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        university.addFaculty(f1);
        university.addFaculty(f2);
        university.addFaculty(f3);

        university.assignFacultyToDepartment("Computer Science", f1);
        university.assignFacultyToDepartment("Mechanical Engineering", f2);

        university.showStructure();

        university = null;
        System.gc();
    }
}
