package temp.multithreading.deadlock;

public class B {

    public synchronized void funB(A a){
        System.out.println("inside funB of B");

        a.fun1();

        System.out.println("funB ends");

    }

    public synchronized void fun2(){
        System.out.println("inside fun2 of B");
    }




}
