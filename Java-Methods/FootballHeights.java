

import java.util.Random;

public class FootballHeights {

    // Generate 3-digit random heights in cm
    public static int[] generateHeights(int count) {
        Random rand = new Random();
        int[] heights = new int[count];
        for (int i = 0; i < count; i++) {
            heights[i] = 150 + rand.nextInt(101); // Range 150–250
        }
        return heights;
    }

    // Find sum of heights
    public static int sum(int[] heights) {
        int total = 0;
        for (int h : heights) total += h;
        return total;
    }

    // Find shortest height
    public static int findMin(int[] heights) {
        int min = heights[0];
        for (int h : heights)
            if (h < min) min = h;
        return min;
    }

    // Find tallest height
    public static int findMax(int[] heights) {
        int max = heights[0];
        for (int h : heights)
            if (h > max) max = h;
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateHeights(11);

        System.out.print("Player Heights: ");
        for (int h : heights) System.out.print(h + " ");
        System.out.println();

        int total = sum(heights);
        double mean = total / 11.0;
        System.out.println("Shortest: " + findMin(heights) + " cm");
        System.out.println("Tallest : " + findMax(heights) + " cm");
        System.out.printf("Mean Height: %.2f cm\n", mean);
    }
}
