package Study.concurrent.pro_con.lock;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            buffer.put();
        }
    }
}
