package Study.concurrent.pro_con.sync;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by lenovo on 2017/12/4.
 */
public class Buffer {
    private int maxSize;
    private LinkedList<Date> storage;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        storage = new LinkedList<>();
    }

    public synchronized void put() {
        try {
            while (storage.size() == maxSize) {
                System.out.println(Thread.currentThread().getName() + " waiting ...");
                wait();
            }
            storage.offerLast(new Date());
            System.out.println(Thread.currentThread().getName() + " : put: " + storage.size());
//            Thread.sleep(1000);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void take() {
        try {
            while (storage.size() == 0) {
                System.out.println(Thread.currentThread().getName() + " waiting ...");
                wait();
            }
            storage.pollFirst();
            System.out.println(Thread.currentThread().getName() + " : take :" + storage.size());
//            Thread.sleep(1000);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
