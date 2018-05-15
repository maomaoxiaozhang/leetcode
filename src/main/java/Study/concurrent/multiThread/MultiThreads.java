package Study.concurrent.multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreads {
    static volatile Integer i = 0;

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();
        new Thread(new Inner("A", lock, a, b)).start();
        new Thread(new Inner("b", lock, b, c)).start();
        new Thread(new Inner("c", lock, c, a)).start();


    }

    public static class Inner implements Runnable{
        private String str;
        private Lock lock;
        private Condition cur;
        private Condition next;

        public Inner(String str, Lock lock, Condition cur, Condition next) {
            this.str = str;
            this.lock = lock;
            this.cur = cur;
            this.next = next;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    System.out.println(str);
                    next.signal();
                    cur.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}