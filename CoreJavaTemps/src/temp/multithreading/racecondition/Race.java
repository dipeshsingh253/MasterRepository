package temp.multithreading.racecondition;

public class Race{
    public static void main(String[] args) throws InterruptedException {
//        Counter counter = new Counter();
//
//        Thread thread1 = new Thread(counter,"Thread-1");
//        Thread thread2 = new Thread(counter,"Thread-2");
//        Thread thread3 = new Thread(counter,"Thread-3");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();


        Common common = new Common();
        OvercomeRace overcomeRace = new OvercomeRace(common, "Logwin");

        Thread thread4 = new Thread(overcomeRace,"Dipesh");
        Thread thread5 = new Thread(overcomeRace,"Dipak");
        Thread thread6 = new Thread(overcomeRace, "Shivay");

        thread4.start();
//        thread4.join();
        thread5.start();
//        thread5.join();
        thread6.start();
//        thread6.join();

    }
}
