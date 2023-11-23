package temp.multithreading.racecondition;

public class OvercomeRace implements Runnable{

    private Common common;
    private String name;

    public OvercomeRace(Common common, String name) {
        this.common = common;
        this.name = name;
    }


    @Override
    public void run() {
        synchronized (this){
            System.out.println("Welcome "+Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("to ");
            common.fun1(name);
        }
    }
}
