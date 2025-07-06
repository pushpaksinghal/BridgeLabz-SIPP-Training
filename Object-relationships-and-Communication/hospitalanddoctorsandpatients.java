import java.util.*;

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patientes> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patientes patient) {
        patients.add(patient);
    }

    public void showAllDoctors() {
        System.out.println("Doctors at " + name + ":");
        for (Doctor d : doctors) {
            System.out.println(" " + d.getName());
        }
    }

    public void showAllPatients() {
        System.out.println("Patients at " + name + ":");
        for (Patientes p : patients) {
            System.out.println(" " + p.getName());
        }
    }
}

class Doctor {
    private String name;
    private List<Patientes> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void consult(Patientes patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
        System.out.println("Doctor " + name + " is consulting Patient " + patient.getName());
    }

    public String getName() {
        return name;
    }

    public void showPatients() {
        System.out.println("Patients of Dr. " + name + ":");
        for (Patientes p : patients) {
            System.out.println(" " + p.getName());
        }
    }
}

class Patientes {
    private String name;
    private List<Doctor> doctors;

    public Patientes(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public String getName() {
        return name;
    }

    public void showDoctors() {
        System.out.println("Doctors consulted by " + name + ":");
        for (Doctor d : doctors) {
            System.out.println(" " + d.getName());
        }
    }
}

public class hospitalanddoctorsandpatients {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor d1 = new Doctor("Dr. Sharma");
        Doctor d2 = new Doctor("Dr. Mehta");

        Patientes p1 = new Patientes("Ravi");
        Patientes p2 = new Patientes("Sita");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        hospital.addPatient(p1);
        hospital.addPatient(p2);

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        d1.showPatients();
        d2.showPatients();

        p1.showDoctors();
        p2.showDoctors();

        hospital.showAllDoctors();
        hospital.showAllPatients();
    }
}
