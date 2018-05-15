package Study.concurrent.pro_con.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.put(1);
                System.out.println("Producer " + Thread.currentThread().getName() + " ----- " + queue.size());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
