package temp.serialization.charoriented;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterExample {


    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("buffered.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(100);
        bw.newLine();
        bw.write("I love");
        bw.newLine();
        bw.write("my work");
        bw.newLine();

        char[] chr = {'a','b','c'};
        bw.write(chr);

        bw.flush();
        bw.close();

        System.out.println("Done");


    }

}
