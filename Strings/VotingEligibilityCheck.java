import java.util.Random;

public class VotingEligibilityCheck {
    public static void main(String[] args) {
        int[] ages = generateRandomAges(10);
        String[][] results = checkVoting(ages);
        for (int i = 0; i < ages.length; i++) {
            System.out.println("Age: " + results[i][0] + " Can Vote: " + results[i][1]);
        }
    }

    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + rand.nextInt(60);
        }
        return ages;
    }

    public static String[][] checkVoting(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            result[i][1] = ages[i] >= 18 ? "true" : "false";
        }
        return result;
    }
}
