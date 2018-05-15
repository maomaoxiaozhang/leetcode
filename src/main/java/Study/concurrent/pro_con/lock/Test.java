package Study.concurrent.pro_con.lock;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Test {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(3);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        for (int i = 0; i < 3; i++) {
            new Thread(producer, "producer-" +i).start();
        }
        for (int i = 0; i < 3; i++)
            new Thread(consumer, "consumer-" + i).start();
    }
}
