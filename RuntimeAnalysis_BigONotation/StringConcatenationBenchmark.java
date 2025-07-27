public class StringConcatenationBenchmark {

    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        // Using String (Inefficient)
        long startString = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += text;
        }
        long endString = System.nanoTime();
        System.out.println("String Time: " + (endString - startString) / 1_000_000.0 + " ms");

        // Using StringBuilder (Efficient)
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endBuilder = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endBuilder - startBuilder) / 1_000_000.0 + " ms");

        // Using StringBuffer (Thread-safe, slightly slower)
        long startBuffer = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sf.append(text);
        }
        long endBuffer = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endBuffer - startBuffer) / 1_000_000.0 + " ms");
    }
}
