package temp.serialization.niopackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

//            checkFileExistence();
//            writeSomethingToFile();
//            readingAFileLineByLine();
//            usingTerminalOperationWithStream();
//            readingFromOneFileAndWritingToOther();
//            copyFile();





//        List<String> data = Files.readAllLines(path);
//
//        for (String s : data)
//            System.out.println(s);

//        Files.lines(path).forEach(System.out::println);

    }

    static void copyFile() throws IOException {
        Path source = Paths.get("abc.txt");
        Path destination = Paths.get("abc_copy.txt");

        Files.copy(source,destination);

    }

    static void readingFromOneFileAndWritingToOther() throws IOException {
        Path source = Paths.get("abc.txt");
        Path destination = Paths.get("destination.txt");

        Files.createFile(destination);

        List<String> strings = Files.readAllLines(source);

        Files.write(destination,strings);
        System.out.println("Done");


    }

    static void writeSomethingToFile() throws IOException {

        Path p = Paths.get("abc.txt");
        String message = " Java is my favourite language";

//        Files.write(p,message.getBytes());

        List<String> list = Arrays.asList("delhi","mumbai","kolkata");


        // writing list of string
//        Files.write(p,list);
//
        // in append mode
        Files.write(p,list, StandardOpenOption.APPEND);

        System.out.println("done");

    }

    static void checkFileExistence() throws IOException {
        Path path = Paths.get("abc.txt");

        if (Files.exists(path)){
            System.out.println("File already exists...");
        }else {
            Path path2 = Files.createFile(path);
            System.out.println("new file created at : "+ path2);
        }
    }

    static void readingAFileLineByLine() throws IOException {

        Path p = Paths.get("abc.txt");
        List<String> strings = Files.readAllLines(p);

        for (String s : strings)
            System.out.println(s);
    }

    static void usingTerminalOperationWithStream() throws IOException {
        Path p = Paths.get("abc.txt");
        Stream<String> string = Files.lines(p);

        string.map((line) -> {
            if (line.contains("mumbai")){
                return line.replace("mumbai","Bombay");
            }else {
                return line;
            }
        }).forEach(System.out::println);
    }

}
