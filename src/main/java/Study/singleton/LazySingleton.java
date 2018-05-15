package Study.singleton;

public class LazySingleton {

    private static class SingletonHolder{
        public static LazySingleton singleton = new LazySingleton();
    }

    public static LazySingleton getSingleton() {
        return SingletonHolder.singleton;
    }
}
