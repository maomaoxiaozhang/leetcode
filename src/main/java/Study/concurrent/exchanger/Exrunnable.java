package Study.concurrent.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by lenovo on 2017/12/2.
 */
public class Exrunnable implements Runnable{
    private Exchanger exchanger;
    private Object object;
    private int num;

    public Exrunnable(Exchanger exchanger, Object object, int num) {
        this.exchanger = exchanger;
        this.object = object;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            Object previous = this.object;
            System.out.println(Thread.currentThread().getName() + " arrive");
            Thread.sleep(1000*num);
            this.object = this.exchanger.exchange(this.object);
            System.out.println(Thread.currentThread().getName() + " exchange " + previous + " for " + this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
