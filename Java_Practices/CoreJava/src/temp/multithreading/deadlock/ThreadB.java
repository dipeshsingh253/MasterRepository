package temp.multithreading.deadlock;

public class ThreadB extends Thread{

    A a;
    B b;
    public ThreadB(A a, B b){
        this.a = a;
        this.b = b;
    }


    @Override
    public void run() {
        b.funB(a);
    }
}
