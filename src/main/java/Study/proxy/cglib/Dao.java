package Study.proxy.cglib;

/**
 * Created by lenovo on 2018/1/25.
 */
public class Dao {
    public Dao() {
        update();
    }

    public void update() {
        System.out.println("update");
    }

    public void select() {
        System.out.println("select");
    }
}
