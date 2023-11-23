package temp.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person p1 = new Person(1,"Dipesh","dj@mail.com","0000000000","Address - 1","password",true);
        Person p2 = new Person(2,"Raj","rj@mail.com","0000000000","Address - 2","password",false);
        Person p3 = new Person(3,"Gaurav","gj@mail.com","0000000000","Address - 3","password",false);

        List<Person> persons = Arrays.asList(p1,p2,p3);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.externalization"));

        persons.forEach(person -> {
            try {
                person.writeExternal(out);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        out.close();
        System.out.println("Done");

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.externalization"));

        List<Person> data = new ArrayList<>();


        try {
            while (true){
                Person p = new Person();
                p.readExternal(in);
                data.add(p);
            }
        }catch (EOFException e){

        }

        data.forEach(System.out::println);



    }

}
