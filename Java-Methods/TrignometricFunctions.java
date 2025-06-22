
import java.util.Scanner;

public class TrignometricFunctions {
    //Created a method for calculating trignometric function
    public double[] caculateTrignometricFunctions(double angle){
        double[] trignometricFunctions = new double[3];

        //converting degree to radian
        double radian = Math.toRadians(angle);

        //Calculating value of Sin,Cosine,Tangent
        double sin = Math.sin(radian);
        double cosine = Math.cos(radian);
        double tangent = Math.tan(radian);
        trignometricFunctions[0] = sin;
        trignometricFunctions[1] = cosine;
        trignometricFunctions[2] = tangent;
        return trignometricFunctions;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //creating an object obj of class
        TrignometricFunctions obj = new TrignometricFunctions();

        //Taking input for angle
        double angle = sc.nextDouble();
        double[] trignometricFunctions = obj.caculateTrignometricFunctions(angle);
        System.out.printf("At angle %.2f Value of Sin = %.2f Value of Cos = %.2f Value of Tan = %.2f",angle,trignometricFunctions[0],trignometricFunctions[1],trignometricFunctions[2]);
    }
}
