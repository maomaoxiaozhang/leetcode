package Study.io.bio;

import java.io.IOException;
import java.util.Random;

/**
 * Created by lenovo on 2018/1/28.
 */
public class BIO {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                Server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
        char operators[] = {'+','-','*','/'};
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                String expression = random.nextInt(10)+""+operators[random.nextInt(4)]+(random.nextInt(10)+1);
                Client.send(expression);
            }).start();
        }
    }
}
