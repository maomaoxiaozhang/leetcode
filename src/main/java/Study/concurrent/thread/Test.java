package Study.concurrent.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;

/**
 * Created by lenovo on 2017/12/2.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        for (int i = 0; i < 10; i++)
            System.out.println(futureTask.get());
    }
}
