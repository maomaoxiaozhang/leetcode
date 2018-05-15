package Study.concurrent.pro_con.copy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        lock_buffer buffer = new lock_buffer(3);
        for (int i = 0; i < 3; i++) {
            new Thread(new pro(buffer), "pro-"+i).start();
            new Thread(new con(buffer), "con-"+i).start();
        }
    }

    static class sync_buffer{
        LinkedList<String> buffer = new LinkedList<>();
        int size;

        public sync_buffer(int size) {
            this.size = size;
        }

        public synchronized void take() {
            try {
                while (buffer.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + " -- empty");
                    wait();
                }
                buffer.pollFirst();
                System.out.println(Thread.currentThread().getName() + " -- take -- " + buffer.size());
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void put() {
            try {
                while (buffer.size() == size) {
                    System.out.println(Thread.currentThread().getName() + " -- full");
                    wait();
                }
                buffer.offerLast("lalal");
                System.out.println(Thread.currentThread().getName() + " -- put --" + buffer.size());
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class lock_buffer{
        ReentrantLock lock;
        Condition notFull;
        Condition notEmpty;
        int size;
        LinkedList<String> buffer;

        public lock_buffer(int size) {
            this.size = size;
            lock = new ReentrantLock();
            notFull = lock.newCondition();
            notEmpty = lock.newCondition();
            buffer = new LinkedList<>();
        }

        public void take() {
            lock.lock();
            try {
                while (buffer.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + " empty");
                    notEmpty.await();
                }
                buffer.pollFirst();
                System.out.println(Thread.currentThread().getName() + " -- take -- " + buffer.size());
                notFull.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        public void put() {
            lock.lock();
            try {
                while (buffer.size() == size) {
                    System.out.println(Thread.currentThread().getName() + " full");
                    notFull.await();
                }
                buffer.offerLast("lalala");
                System.out.println(Thread.currentThread().getName() + " -- put -- " + buffer.size());
                notEmpty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    class bq_buffer{

    }

    //将仓库、生产者、消费者分别抽象出来
    static class pro implements Runnable{
        lock_buffer buffer;

        public pro(lock_buffer buffer) {
            this.buffer = buffer;
        }


        @Override
        public void run() {
            while (true) {
                buffer.put();
            }
        }
    }

    static class con implements Runnable{
        lock_buffer buffer;

        public con(lock_buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            while (true){
                buffer.take();
            }
        }
    }

}