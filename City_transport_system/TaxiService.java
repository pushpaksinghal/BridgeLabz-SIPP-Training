public class TaxiService implements InnerTransportService {
    private String name;
    private double fare;
    private String schedule;

    public TaxiService(String name, double fare, String schedule) {
        this.name = name;
        this.fare = fare;
        this.schedule = schedule;
    }

    @Override
    public String getname() {
        return name;
    }

    @Override
    public double getfare() {
        return fare;
    }

    @Override
    public String getSchedule() {
        return schedule;
    }
    
}
