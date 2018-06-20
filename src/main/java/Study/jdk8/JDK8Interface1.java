package Study.jdk8;

@FunctionalInterface
public interface JDK8Interface1 {


    void help();

    public static void staticMethod_2() {
        System.out.println("1 static method 2");
    }

    public static void staticMethod() {
        System.out.println("1 static method");
    }

    public default void defaultMethod() {
        System.out.println("1 default method");
    }

    public default void defaultMethod_2() {
        System.out.println("1 default method 2");
    }
}
