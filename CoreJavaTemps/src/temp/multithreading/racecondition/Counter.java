package temp.multithreading.racecondition;

public class Counter implements Runnable{

    private int c;

    public void increment(){
        c++;
    }

    public void decrement(){
        c--;
    }

    public int getCount() {
        return c;
    }

    @Override
    public void run() {
        synchronized (this) {
            //incrementing
            this.increment();
            System.out.println("Value for Thread After increment " + Thread.currentThread().getName() + " " + this.getCount());


            //decrementing
            this.decrement();
            System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getCount());
        }
    }
}
