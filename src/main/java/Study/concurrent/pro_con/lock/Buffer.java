package Study.concurrent.pro_con.lock;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Buffer {
    private final Lock lock;
    private final Condition full;
    private final Condition empty;
    private int maxSize;
    private LinkedList<Date> storage;

    public Buffer(int maxSize) {
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
        this.maxSize = maxSize;
        storage = new LinkedList<>();
    }

    public void put() {
        lock.lock();
        try {
            while (storage.size() == maxSize) {
                System.out.println(Thread.currentThread().getName() + " : waiting to put");
                full.await();
            }
            storage.offerLast(new Date());
            System.out.println(Thread.currentThread().getName() + " : put: " + storage.size());
//            Thread.sleep(1000);
            empty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            while (storage.size() == 0) {
                System.out.println(Thread.currentThread().getName() + " : waiting to take");
                empty.await();
            }
            storage.pollFirst();
            System.out.println(Thread.currentThread().getName() + " : take: " + storage.size());
//            Thread.sleep(1000);
            full.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
