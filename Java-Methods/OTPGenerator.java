
import java.util.HashSet;

public class OTPGenerator {

    // Generate a single 6-digit OTP
    public static int generateOTP() {
        return 100000 + (int) (Math.random() * 900000);
    }

    // Check if all OTPs in the array are unique
    public static boolean areOTPsUnique(int[] otps) {
        HashSet<Integer> set = new HashSet<>();
        for (int otp : otps) {
            if (!set.add(otp)) return false; // Duplicate found
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];

        // Generate 10 OTPs
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }

        // Check uniqueness
        System.out.println("All OTPs are unique: " + areOTPsUnique(otps));
    }
}
