public class CircularTour {
    public static int findStart(int[] petrol, int[] distance) {
        int start = 0, deficit = 0, capacity = 0;
        for (int i = 0; i < petrol.length; i++) {
            capacity += petrol[i] - distance[i];
            if (capacity < 0) {
                start = i + 1;
                deficit += capacity;
                capacity = 0;
            }
        }
        return (capacity + deficit >= 0) ? start : -1;
    }
}
