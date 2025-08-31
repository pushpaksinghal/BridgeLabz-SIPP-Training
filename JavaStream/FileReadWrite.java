import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class FileReadWrite {
    public static void main(String[] args) {
        String sourcePath = "D:\\input.txt";
        String destinationPath = "D:\\output.txt";

        File sourceFile = new File(sourcePath);

        if (!sourceFile.exists()) {
            System.err.println("Source file does not exist at " + sourcePath);
            return;
        }

        try(FileInputStream fis = new FileInputStream(sourcePath)) {
            FileOutputStream fos = new FileOutputStream(destinationPath);

            int byteData;

            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File " + sourcePath + " copied successfully at " + destinationPath);

        }catch (IOException e) {
            System.err.println("An error occurred while handling the file!");
            e.printStackTrace();
        }
    }
}