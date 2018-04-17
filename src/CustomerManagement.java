
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CustomerManagement {
    private static void coppyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0){
                outputStream.write(buffer,0, length);
            }

        }finally {
            inputStream.close();
            outputStream.close();
        }
    }

    public static void main(String[] args) {
        File sourceFile = new File("source.rtf");
        File destFile = new File("dest.rtf");

        try {
            coppyFileUsingJava7Files(sourceFile, destFile);
            System.out.println("coppy complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
