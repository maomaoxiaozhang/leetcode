package Study.singleton;

public class EagerSingleton {
    private static EagerSingleton singleton = new EagerSingleton();

    public static EagerSingleton getSingleton() {
        return singleton;
    }
}
