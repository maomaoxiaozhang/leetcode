package Study.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lenovo on 2017/12/1.
 */
public class Waiter implements Runnable{
    private CountDownLatch latch;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }


    @Override
    public void run() {
        System.out.println("wait start");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wait end");
    }
}
