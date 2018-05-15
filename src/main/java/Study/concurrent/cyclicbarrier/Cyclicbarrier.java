package Study.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by lenovo on 2017/12/1.
 */
public class Cyclicbarrier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2, () -> System.out.println("barrier end"));
        new Thread(new Cyclicbarrierexec(barrier)).start();
        new Thread(new Cyclicbarrierexec(barrier)).start();
    }
}
