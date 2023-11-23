package temp.multithreading.executorframework;

public class PrintJob implements Runnable{

    private String name;

    public PrintJob(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(name +" job started by Thread :"+Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name +"..job completed by Thread :"+Thread.currentThread().getName());
    }
}
