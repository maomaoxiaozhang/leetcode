package Study.jvm;

/**
 * Created by lenovo on 2018/1/3.
 */
public class JVM {
    public static void main(String[] args) {
        SuperClass subClass = new SubClass();
    }

    static class SuperClass {

        public static String string = new String("lalalal");
        static {
            System.out.println("SuperClass init !");
        }

        public SuperClass() {
            System.out.println("constructor");
        }
        int m = 0;
    }

    static class SubClass extends SuperClass {
        int b = 1;

        public static SuperClass superClass = new SuperClass();
        static {
            System.out.println("SubClass init !");
        }

        int a = 1;

        public SubClass() {
            System.out.println("sub con");
        }
    }
}
