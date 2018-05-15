package Study.concurrent.sync;

/**
 * Created by lenovo on 2017/12/3.
 */
public class Test {
    public static void main(String[] args) {
        Integer i = 1;
        try {
            i.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
