import java.util.Scanner;

public class EmployeeBonusCalculatorArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salary = new double[10];
        int[] service = new int[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalBonus = 0, totalOld = 0, totalNew = 0;

        for (int i = 0; i < 10; i++) {
            double s = sc.nextDouble();
            int y = sc.nextInt();
            if (s < 0 || y < 0) {
                i--;
                continue;
            }
            salary[i] = s;
            service[i] = y;
        }

        for (int i = 0; i < 10; i++) {
            bonus[i] = service[i] > 5 ? 0.05 * salary[i] : 0.02 * salary[i];
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOld += salary[i];
            totalNew += newSalary[i];
        }

        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOld);
        System.out.println("Total New Salary: " + totalNew);
    }
}
