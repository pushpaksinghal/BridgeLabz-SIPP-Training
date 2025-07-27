public class FirstLastOccurrence {
    public static int first(int[] arr, int target) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == target) {
                res = m;
                r = m - 1;
            } else if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return res;
    }

    public static int last(int[] arr, int target) {
        int l = 0, r = arr.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == target) {
                res = m;
                l = m + 1;
            } else if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 5, 6};
        int target = 4;
        System.out.println("First: " + first(arr, target));
        System.out.println("Last: " + last(arr, target));
    }
}
