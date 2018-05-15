package Study.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lenovo on 2017/12/1.
 */
public class Countdownlatch {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        new Thread(new Waiter(latch)).start();
        new Thread(new Decrementer(latch)).start();
    }
}
