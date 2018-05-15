package Study.concurrent.blockingqueue;

import java.util.concurrent.*;

/**
 * Created by lenovo on 2017/12/1.
 */
public class Blockingqueue {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
