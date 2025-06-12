import java.util.Scanner;

public class travelpaln {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String FRomcity = sc.nextLine();
        String viaCity = sc.nextLine();
        String toCity = sc.nextLine();

        Double fromtovia = sc.nextDouble();
        Double viatoFinalcity = sc.nextDouble();

        Double timefromvia = sc.nextDouble();
        Double timeToFinalcity = sc.nextDouble();

        Double totalDistance = fromtovia + viatoFinalcity;
        Double totalTime = timefromvia + timeToFinalcity; 

        System.out.print("hte total distance tavelled from " + FRomcity + " to " + toCity + " via " + viaCity + " is " + totalDistance + " and the total time taken is " + totalTime);

    }
}
