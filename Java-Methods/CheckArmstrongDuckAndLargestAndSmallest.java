
public class CheckArmstrongDuckAndLargestAndSmallest {

    public static int[] getDigits(int number) {
        return String.valueOf(number).chars().map(c -> c - '0').toArray();
    }

    public static boolean isDuckNumber(int number) {
        String str = String.valueOf(number);
        return str.contains("0") && str.charAt(0) != '0';
    }

    public static boolean isArmstrong(int number) {
        int[] digits = getDigits(number);
        int power = digits.length;
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == number;
    }

    public static void findTwoLargestSmallest(int[] digits) {
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

        for (int d : digits) {
            // Max
            if (d > firstMax) {
                secondMax = firstMax;
                firstMax = d;
            } else if (d > secondMax && d != firstMax) {
                secondMax = d;
            }

            // Min
            if (d < firstMin) {
                secondMin = firstMin;
                firstMin = d;
            } else if (d < secondMin && d != firstMin) {
                secondMin = d;
            }
        }

        System.out.println("Largest: " + firstMax + ", Second Largest: " + secondMax);
        System.out.println("Smallest: " + firstMin + ", Second Smallest: " + secondMin);
    }

    public static void main(String[] args) {
        int num = 153;

        System.out.println("Is Duck: " + isDuckNumber(num));
        System.out.println("Is Armstrong: " + isArmstrong(num));
        findTwoLargestSmallest(getDigits(num));
    }
}
