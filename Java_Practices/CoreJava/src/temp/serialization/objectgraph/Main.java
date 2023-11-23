package temp.serialization.objectgraph;

import java.io.Serializable;


public class Main{
    public static void main(String[] args) {


    }
}

class Dog implements Serializable {
Cat c=new Cat();
}
class Cat implements Serializable{

    Rat rat = new Rat();

}

class Rat implements Serializable{

}

