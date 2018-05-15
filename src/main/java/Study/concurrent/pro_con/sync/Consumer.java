package Study.concurrent.pro_con.sync;

/**
 * Created by lenovo on 2017/12/4.
 */
public class Consumer implements Runnable{
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            buffer.take();
        }
    }
}
