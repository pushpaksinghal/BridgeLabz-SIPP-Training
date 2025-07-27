import java.io.*;

public class FileReadPerformance {

    public static void readWithFileReader(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        long start = System.nanoTime();
        while ((line = br.readLine()) != null) {}
        long end = System.nanoTime();
        br.close();
        System.out.println("FileReader Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void readWithInputStreamReader(String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        long start = System.nanoTime();
        while ((line = br.readLine()) != null) {}
        long end = System.nanoTime();
        br.close();
        System.out.println("InputStreamReader Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) throws IOException {
        String filePath = "largefile.txt"; // Replace with your test file path

        System.out.println("Reading File: " + filePath);
        readWithFileReader(filePath);
        readWithInputStreamReader(filePath);
    }
}
