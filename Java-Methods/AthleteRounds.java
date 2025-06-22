import java.util.Scanner;

public class AthleteRounds {

    //Methods to calculate the total round athlete needs to complete 5km
    public int calculateRounds(double sideA,double sideB,double sideC) {
        double perimeterOfTriangle = sideA+sideB+sideC;
        return (int) Math.ceil(5.0 /perimeterOfTriangle);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //creating an object obj of class
        AthleteRounds obj = new AthleteRounds();

        //taking input for all sides of triangle
        double sideA = sc.nextInt();
        double sideB = sc.nextInt();
        double sideC = sc.nextInt();

        int rounds = obj.calculateRounds(sideA,sideB,sideC);
        System.out.printf("For sides %.2f , %.2f , %.2f the Requirred rounds are : %d",sideA,sideB,sideC,rounds);
    }
}
