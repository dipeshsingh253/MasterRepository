package temp.multithreading;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread(15);

        myThread.setName("Child Thread");

        myThread.start();

        synchronized (myThread){
            System.out.println("main thread calls the wait method");
            myThread.wait(5000);
            System.out.println("main thread got the notification");
            System.out.println(myThread.num);
        }


    }

}
