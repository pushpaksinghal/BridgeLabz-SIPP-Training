public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            boolean leftOk = (mid == 0) || arr[mid] > arr[mid - 1];
            boolean rightOk = (mid == arr.length - 1) || arr[mid] > arr[mid + 1];

            if (leftOk && rightOk) {
                System.out.println("Peak: " + arr[mid]);
                return;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) right = mid - 1;
            else left = mid + 1;
        }
    }
}
