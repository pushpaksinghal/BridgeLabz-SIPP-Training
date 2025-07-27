public class ComparePerformance {
    public static void main(String[] args) {
        long start, end;
        StringBuffer sb1 = new StringBuffer();
        StringBuilder sb2 = new StringBuilder();

        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) sb1.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) sb2.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start) + " ns");
    }
}
