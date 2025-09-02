public class AmbulanceService implements EmergencyService, InnerTransportService {
    private String name;
    private double fare;
    private String schedule;

    public AmbulanceService(String name, double fare, String schedule) {
        this.name = name;
        this.fare = fare;
        this.schedule = schedule;
    }

    public String getname() {
        return "Ambulance Service";
    }

    public double getfare() {
        return 0.0;
    }

    public String getSchedule() {
        return "24/7";
    }
    
}
