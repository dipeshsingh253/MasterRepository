package temp.multithreading.deadlock;

public class Main {
    /**
     *  we don't have any solution for deadlock situation but we can avoid deadlock situation with precaution.
     *  in this given example we can avoid deadlock situation by removing synchronized keyword from any of the method of A or B class.
     */
    public static void main(String[] args) {

        A a = new A();
        B b = new B();

        ThreadA threadA = new ThreadA(a,b);
        ThreadB threadB = new ThreadB(a,b);

        threadA.start();
        threadB.start();
    }

}
