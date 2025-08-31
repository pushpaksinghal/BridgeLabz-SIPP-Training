package QUEUE.HospitalTriageSystem;

class Patient {
    private final String name;
    private final int severity;

    public Patient (String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }
}