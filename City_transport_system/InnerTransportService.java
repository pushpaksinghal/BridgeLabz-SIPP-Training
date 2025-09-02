interface InnerTransportService {
    String getname();
    double getfare();
    String getSchedule();

    default void printServiceDetails(){
        System.out.println("Name: " + getname()+
        "Fare: " + getfare()+
        "Schedule: " + getSchedule());
    }
    
}