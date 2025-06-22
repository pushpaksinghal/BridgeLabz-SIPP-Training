
import java.util.Scanner;

public class FriendsAnalyzer {

    // Method to find index of the youngest friend
    public static int findYoungest(int[] ages) {
        int min = ages[0], index = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < min) {
                min = ages[i];
                index = i;
            }
        }
        return index;
    }

    // Method to find index of the tallest friend
    public static int findTallest(int[] heights) {
        int max = heights[0], index = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) {
                max = heights[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        int[] heights = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height (in cm) of " + names[i] + ": ");
            heights[i] = sc.nextInt();
        }

        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        System.out.println("Youngest friend is: " + names[youngestIndex]);
        System.out.println("Tallest friend is: " + names[tallestIndex]);

        sc.close();
    }
}
