interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

abstract class HospitalPatient {
    private String patientId;
    private String name;
    private int age;

    HospitalPatient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

class InPatientRecord extends HospitalPatient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private String records = "";

    InPatientRecord(String id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    public void addRecord(String record) {
        records += record + "\n";
    }

    public String viewRecords() {
        return records;
    }
}

class OutPatientRecord extends HospitalPatient implements MedicalRecord {
    private double consultationFee;
    private String records = "";

    OutPatientRecord(String id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        records += record + "\n";
    }

    public String viewRecords() {
        return records;
    }
}

public class HSystem {
    public static void main(String[] args) {
        HospitalPatient[] patients = new HospitalPatient[2];

        InPatientRecord p1 = new InPatientRecord("P101", "Alice", 30, 5, 1000);
        p1.addRecord("Appendicitis surgery");

        OutPatientRecord p2 = new OutPatientRecord("P102", "Bob", 24, 500);
        p2.addRecord("General checkup");

        patients[0] = p1;
        patients[1] = p2;

        for (HospitalPatient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: $" + p.calculateBill());
            if (p instanceof MedicalRecord) {
                System.out.println("Medical Records:\n" + ((MedicalRecord) p).viewRecords());
            }
            System.out.println();
        }
    }
}
