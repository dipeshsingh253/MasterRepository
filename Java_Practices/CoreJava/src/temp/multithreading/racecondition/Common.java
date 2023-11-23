package temp.multithreading.racecondition;

class Common {
    public void fun1(String name) {
        synchronized (this) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
            System.out.println("We are looking forward to working with you");
        }
    }
}
