package temp.serialization.charoriented;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("abc.txt");

        fw.write(100);
        fw.write("welcome dipesh");
        fw.write("\n");
        fw.write("to logwin technologies");
        char[] ch = {'a','b','c','d'};
        fw.write(ch);

        fw.flush();
        fw.close();

        System.out.println("done");

    }

}
