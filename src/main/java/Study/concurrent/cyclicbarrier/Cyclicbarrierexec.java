package Study.concurrent.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by lenovo on 2017/12/1.
 */
public class Cyclicbarrierexec implements Runnable {
    private CyclicBarrier barrier;

    public Cyclicbarrierexec(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "start");
            Thread.sleep(1000*2);
            System.out.println(Thread.currentThread().getName() + "arrive");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + "done");
            System.out.println(Thread.currentThread().getName() + "arrive");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + "done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
