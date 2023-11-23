package temp.serialization;

import java.io.*;

public class A implements Serializable {

    int i=10;

    public void funA(){
        System.out.println("inside funA() of A");
        System.out.println(i);
    }

}


class WriteObject{
    public static void main(String[] args) throws IOException {
        A a = new A();
        a.i = 22;

        FileOutputStream fos = new FileOutputStream("serialization.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(a);
        oos.writeObject("Welcome to Logwin Technologies");
        oos.writeObject(10);

        oos.close();

        System.out.println("object is serialized");

    }
}


class ReadObject{

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("serialization.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object obj = ois.readObject();
        A a = (A)obj;
        a.funA();

        String ss = (String) ois.readObject();
        System.out.println(ss);

        int z = (Integer)ois.readObject();
        System.out.println(z);

        ois.close();

    }

}
