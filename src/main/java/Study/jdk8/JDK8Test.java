package Study.jdk8;

public class JDK8Test {
    public static void main(String[] args) {
        new inner().start();

        System.out.println("over");

    }

    static class inner extends Thread{
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("xiancheng");
        }
    }
}
