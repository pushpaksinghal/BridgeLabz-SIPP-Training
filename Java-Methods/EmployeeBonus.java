
import java.util.Random;

public class EmployeeBonus {

    // Generate 2D array: [][0]=salary, [][1]=yearsOfService
    public static int[][] generateEmployeeData() {
        Random rand = new Random();
        int[][] data = new int[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = 10000 + rand.nextInt(90000); // Salary: 5-digit
            data[i][1] = rand.nextInt(11); // Years of service: 0–10
        }
        return data;
    }

    // Calculate bonus and new salary based on rules
    public static double[][] calculateBonus(int[][] data) {
        double[][] result = new double[10][2]; // [][0]=bonus, [][1]=newSalary
        for (int i = 0; i < 10; i++) {
            double bonus = data[i][1] > 5 ? 0.05 * data[i][0] : 0.02 * data[i][0];
            result[i][0] = bonus;
            result[i][1] = data[i][0] + bonus;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] employeeData = generateEmployeeData();
        double[][] bonusData = calculateBonus(employeeData);

        double totalOld = 0, totalNew = 0, totalBonus = 0;

        // Print and compute totals
        System.out.println("Emp\tSalary\tYears\tBonus\tNew Salary");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%d\t%d\t%.2f\t%.2f\n", i + 1, employeeData[i][0], employeeData[i][1],
                    bonusData[i][0], bonusData[i][1]);
            totalOld += employeeData[i][0];
            totalBonus += bonusData[i][0];
            totalNew += bonusData[i][1];
        }

        System.out.printf("\nTotal Old Salary: %.2f\nTotal Bonus: %.2f\nTotal New Salary: %.2f\n",
                totalOld, totalBonus, totalNew);
    }
}
