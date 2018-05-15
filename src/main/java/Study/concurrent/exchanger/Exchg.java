package Study.concurrent.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Future;

/**
 * Created by lenovo on 2017/12/2.
 */
public class Exchg {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        new Thread(new Exrunnable(exchanger, "A", 0)).start();
        new Thread(new Exrunnable(exchanger, "B", 5)).start();
    }
}
