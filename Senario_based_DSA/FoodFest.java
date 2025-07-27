import java.util.*;

public class FoodFest {

    static class Stall {
        String name;
        int footfall;
        String zone;

        Stall(String name, int footfall, String zone) {
            this.name = name;
            this.footfall = footfall;
            this.zone = zone;
        }

        @Override
        public String toString() {
            return "(" + name + " from " + zone + ", " + footfall + ")";
        }
    }

    static class Zone {
        String zoneName;
        List<Stall> stallsSorted;

        Zone(String zoneName, List<Stall> stallsSorted) {
            this.zoneName = zoneName;
            this.stallsSorted = stallsSorted;
        }
    }

    public static void mergeSort(List<Stall> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);

            List<Stall> leftList = new ArrayList<>(list.subList(left, mid + 1));
            List<Stall> rightList = new ArrayList<>(list.subList(mid + 1, right + 1));

            int i = 0, j = 0, k = left;

            while (i < leftList.size() && j < rightList.size()) {
                if (leftList.get(i).footfall <= rightList.get(j).footfall) {
                    list.set(k++, leftList.get(i++)); 
                } else {
                    list.set(k++, rightList.get(j++));
                }
            }

            while (i < leftList.size()) {
                list.set(k++, leftList.get(i++));
            }

            while (j < rightList.size()) {
                list.set(k++, rightList.get(j++));
            }
        }
    }

    public static void main(String[] args) {
    	Zone zoneA = new Zone("ZoneA", Arrays.asList(
                new Stall("A", 100, "ZoneA"),
                new Stall("B", 150, "ZoneA")
            ));

            Zone zoneB = new Zone("ZoneB", Arrays.asList(
                new Stall("C", 120, "ZoneB"),
                new Stall("D", 150, "ZoneB")
            ));

            List<Stall> masterList = new ArrayList<>();
            masterList.addAll(zoneA.stallsSorted);
            masterList.addAll(zoneB.stallsSorted);

            mergeSort(masterList, 0, masterList.size() - 1);

            System.out.println("Master list sorted by footfall (stable):");
            for (Stall s : masterList) {
                System.out.println(s);
            }
    }
}
