public class SelectionSortScores {
    public static void selectionSort(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIndex])
                    minIndex = j;
            }
            int temp = scores[i]; scores[i] = scores[minIndex]; scores[minIndex] = temp;
        }
    }
}
