import java.util.Random;

public class StudentScorecard {
    public static void main(String[] args) {
        int[][] scores = generateScores(5);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);
        displayReport(scores, stats, grades);
    }

    public static int[][] generateScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + rand.nextInt(90);
            }
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;
            stats[i][0] = total;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return stats;
    }

    public static String[] calculateGrades(double[][] stats) {
        String[] grades = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double p = stats[i][2];
            if (p >= 90) grades[i] = "A+";
            else if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 50) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void displayReport(int[][] scores, double[][] stats, String[] grades) {
        System.out.println("Phy Chem Math Total Avg % Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%3d %4d %4d %5.0f %4.1f %4.1f %s\n",
                scores[i][0], scores[i][1], scores[i][2],
                stats[i][0], stats[i][1], stats[i][2], grades[i]);
        }
    }
}
