package temp.multithreading.deadlock;

public class A {

    public synchronized void funA(B b){
        System.out.println("inside funA of A");


        b.fun2();

        System.out.println("fun A ends");
    }

    public synchronized void fun1(){
        System.out.println("inside fun1 of A");
    }


}
