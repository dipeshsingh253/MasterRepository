package temp.serialization.byteoriented;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyImageToAnotherLocation {

    public static void main(String[] args) throws IOException {

        // location of the image
        FileInputStream fis = new FileInputStream("/home/pc/Downloads/Untitled.png");
        // new location for the image
        FileOutputStream fos = new FileOutputStream("/home/pc/Downloads/java-logo.png");

        int i = fis.read();

        while (i!=-1){
            fos.write(i);
            i = fis.read();
        }

        fos.flush();
        fos.close();
        fis.close();


        System.out.println("Done...");

    }

}
