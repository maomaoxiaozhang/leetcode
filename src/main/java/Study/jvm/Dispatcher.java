package Study.jvm;

/**
 * Created by lenovo on 2018/1/3.
 */
public class Dispatcher {

    class Other{

    }

    class Human {
//        void help() {
//            System.out.println("human");
//        }
    }

    class Man extends Human {
        void help() {
            System.out.println("man");
        }
    }

    class Woman extends Human {
        void help() {
            System.out.println("woman");
        }
    }

    public void sayHello(Human guy) {
        if (guy instanceof Man)
            System.out.println("hello man");
        else if (guy instanceof Human)
            System.out.println("hello guy !");
    }

    public void sayHello(Man man) {
        System.out.println("hello man !");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello woman !");
    }

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        Human man = dispatcher.new Man();
        dispatcher.sayHello((Man) man);
    }
}
