public class StudentMarksSorter {
    public static void main(String[] args) {
        int[] marks = {85, 72, 90, 66, 78, 95, 60};

        System.out.println("Original Marks:");
        printArray(marks);

        bubbleSort(marks);

        System.out.println("\nSorted Marks (Ascending):");
        printArray(marks);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) break; // no swaps = array is sorted
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
