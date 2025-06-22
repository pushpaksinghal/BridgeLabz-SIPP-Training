
import java.util.Arrays;

public class RandomStats {

    // Generate array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = 1000 + (int)(Math.random() * 9000); // range 1000-9999
        }
        return nums;
    }

    // Find average, min, max
    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int num : numbers) {
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }
        double avg = (double) sum / numbers.length;
        return new double[] {avg, min, max};
    }

    public static void main(String[] args) {
        int[] numbers = generate4DigitRandomArray(5);
        System.out.println("Generated Numbers: " + Arrays.toString(numbers));

        double[] stats = findAverageMinMax(numbers);
        System.out.printf("Average: %.2f, Min: %.0f, Max: %.0f\n", stats[0], stats[1], stats[2]);
    }
}
