package test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test{
    public int i = 0;

    public static void main(String[] args) {

        inner in = new inner();
        new Thread(() -> {
            inner.help();
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        in.help(7);
    }

    static class inner {
        synchronized static void help() {
            System.out.println("in");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("over");
        }

        synchronized void help(int i) {
            System.out.println(i);
        }
    }

    static class LazySingleton {

        private LazySingleton() {}

        private static class InstanceHolder {
            private static final LazySingleton instance = new LazySingleton();
        }

        public static LazySingleton getSingleton() {
            return InstanceHolder.instance;
        }
    }
}