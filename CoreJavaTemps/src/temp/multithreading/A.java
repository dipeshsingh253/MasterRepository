package temp.multithreading;

public class A implements Runnable{

    int sum;

    int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i=1;i<=n;i++)sum+=i;
    }


    public static void main(String[] args) throws InterruptedException {
        A a = new A(10);
        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(a);
        thread1.start();

        thread1.join();

        System.out.println(a.sum);

    }


}
