import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    public abstract String getRoleName();
}

class SoftwareEngineer extends JobRole {
    public String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    public String getRoleName() {
        return "Data Scientist";
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private T role;

    public Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public void screen() {
        System.out.println("Screening " + candidateName + " for role: " + role.getRoleName());
    }
}

class ResumeScreening {
    public static void displayRoles(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println(role.getRoleName());
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> r2 = new Resume<>("Bob", new DataScientist());

        r1.screen();
        r2.screen();

        List<JobRole> roles = new ArrayList<>();
        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        displayRoles(roles);
    }
}
