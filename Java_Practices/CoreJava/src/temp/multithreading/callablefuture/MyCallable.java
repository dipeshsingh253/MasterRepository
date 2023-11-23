package temp.multithreading.callablefuture;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {

    int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public Object call() throws Exception {

        System.out.println("calculation sum of n natural numbers by :" + Thread.currentThread().getName());

        int sum = 0;
        for (int i=1;i<=n;i++){
            sum+=i;
        }

        return sum;
    }
}
