import java.util.*;

public class RPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rounds: ");
        int rounds = sc.nextInt();
        int n = rounds; // Save original value for percentage
        int count = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter your choice (1 = Rock, 2 = Paper, 3 = Scissors): ");
            int user = sc.nextInt();

            // Generate random number between 1 and 3
            int computer = (int)(Math.random() * 3) + 1;

            if (user == computer) {
                System.out.println("It's a draw!");
            } else if ((user == 1 && computer == 3) || 
                       (user == 2 && computer == 1) || 
                       (user == 3 && computer == 2)) {
                count++;
                System.out.println("You win! " + choiceName(user) + " beats " + choiceName(computer));
            } else {
                System.out.println("You lose! " + choiceName(computer) + " beats " + choiceName(user));
            }
        }

        System.out.println("\nYou won " + count + " times");
        System.out.println("Your win percentage is " + ((count * 100) / n) + "%");
    }

    public static String choiceName(int choice) {
        switch (choice) {
            case 1: return "Rock";
            case 2: return "Paper";
            case 3: return "Scissors";
            default: return "Invalid";
        }
    }
}
