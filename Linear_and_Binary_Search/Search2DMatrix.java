public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
        };
        int target = 15;
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int val = matrix[mid / cols][mid % cols];

            if (val == target) {
                System.out.println("Found: true");
                return;
            } else if (val < target) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println("Found: false");
    }
}
