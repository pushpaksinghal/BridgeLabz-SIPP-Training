import java.util.Scanner;

public class BMICalculatorArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int persons = sc.nextInt();
        double[] weights = new double[persons];
        double[] heights = new double[persons];
        double[] bmi = new double[persons];
        String[] status = new String[persons];

        for (int i = 0; i < persons; i++) {
            weights[i] = sc.nextDouble();
            heights[i] = sc.nextDouble();
            bmi[i] = weights[i] / Math.pow(heights[i] / 100, 2);

            if (bmi[i] < 18.5) status[i] = "Underweight";
            else if (bmi[i] < 25) status[i] = "Normal";
            else if (bmi[i] < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < persons; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height: " + heights[i]);
            System.out.println("Weight: " + weights[i]);
            System.out.println("BMI: " + bmi[i]);
            System.out.println("Status: " + status[i]);
            System.out.println();
        }
    }
}
