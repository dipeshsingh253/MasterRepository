package temp.multithreading;

public class MyThread extends Thread{
    int num;

    public MyThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {

        synchronized (this){
            System.out.println(Thread.currentThread().getName() + " started processing");

            for (int i=1;i<=10;i++){
                num+=i;
            }

            System.out.println(Thread.currentThread().getName() + " about to notify");
            this.notify();
        }

    }
}
