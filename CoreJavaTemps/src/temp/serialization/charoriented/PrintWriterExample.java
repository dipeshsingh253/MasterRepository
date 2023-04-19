package temp.serialization.charoriented;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {

    public static void main(String[] args) throws IOException {

//        FileWriter fw = new FileWriter("printwriter.txt");
//        PrintWriter pw = new PrintWriter(fw);

        PrintWriter pw = new PrintWriter("printwriter.txt");

        pw.write(100);
        pw.println(100);
        pw.println(true);
        pw.println('c');
        pw.println("amit");

        pw.flush();
        pw.close();

        System.out.println("Done");

    }

}
