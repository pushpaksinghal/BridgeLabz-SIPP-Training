import java.util.Scanner;

import java.util.Calendar;

public class CalendarDisplay {

    // Check if the given year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Get number of days in a month
    public static int getDaysInMonth(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 1 && isLeapYear(year)) return 29; // February leap year
        return days[month];
    }

    // Get name of the month
    public static String getMonthName(int month) {
        String[] names = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return names[month];
    }

    // Get the first day of the month
    // Returns 0 for Sunday, 1 for Monday, ..., 6 for Saturday
    public static int getStartDay(int year, int month) {
        if (month < 2) { // January and February are treated as months 13 and 14 of the previous year
            month += 12;
            year--;
        }

        int q = 1; // Day of the month
        int m = month;
        int k = year % 100; // Year of the century
        int j = year / 100; // Zero-based century

        // Zeller's Congruence formula
        int h = (q + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 + (5 * j)) % 7;

        // Convert Zeller's output to Java's convention: Sunday = 0, Monday = 1, ..., Saturday = 6
        int dayOfWeek = ((h + 6) % 7);

        return dayOfWeek;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get month and year
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt() - 1;
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        int startDay = getStartDay(year, month);
        int days = getDaysInMonth(month, year);
        String monthName = getMonthName(month);

        System.out.println("\n  " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Initial spacing
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print days
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0) System.out.println();
        }

        sc.close();
    }
}
