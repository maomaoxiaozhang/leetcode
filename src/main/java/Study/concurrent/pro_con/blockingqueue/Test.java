package Study.concurrent.pro_con.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Test {
    public static void main(String[] args) {
        int size = 3;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(size);
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);
        for (int i = 0; i < 3; i++)
            new Thread(producer, "producer-" + i).start();
        for (int i = 0; i < 3; i++)
            new Thread(consumer, "consumer-" + i).start();
    }
}
