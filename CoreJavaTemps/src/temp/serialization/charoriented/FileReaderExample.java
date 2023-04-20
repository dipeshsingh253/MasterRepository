package temp.serialization.charoriented;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

    public static void main(String[] args) throws IOException {
//        // reading from the file using string file name
//        FileReader fr = new FileReader("abc.txt");
//
//        int i = fr.read();
//
//        while (i != -1){
//            System.out.print((char) i);
//            i = fr.read();
//        }
//
//        System.out.println("done");


        // reading from the file using File object

        File file = new File("abc.txt");

        FileReader fileReader = new FileReader(file);

        char[] chr = new char[(int)file.length()];

        fileReader.read(chr);

        for(char c : chr)
            System.out.print(c);

        System.out.println("done");
    }

}
