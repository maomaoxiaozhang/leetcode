package Study.concurrent.pro_con.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.take();
                System.out.println("consumer " + Thread.currentThread().getName() + " ----- " + queue.size());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
