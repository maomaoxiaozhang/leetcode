package Study.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lenovo on 2017/12/1.
 */
public class Decrementer implements Runnable{
    private CountDownLatch latch;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("count down start");
        try {
            latch.countDown();
            Thread.sleep(1000*2);
            latch.countDown();
            Thread.sleep(1000*2);
            latch.countDown();
            latch.countDown();
            latch.countDown();
            latch.countDown();
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count down end");
    }
}
