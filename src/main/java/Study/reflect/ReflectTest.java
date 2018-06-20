package Study.reflect;

public class ReflectTest {
    public static void main(String[] args) {
        Father father = new Son();
        System.out.println(father.a);
        System.out.println(father.b);
        System.out.println(father.c);
        father.help();

        Son son = new Son();
        System.out.println(son.a);
        System.out.println(son.b);
        System.out.println(son.c);
        son.help();
    }
}

class Father {
    public int a = 1;
    public static int b = 2;
    public static final int c = 3;

    public void help() {
        System.out.println("\t" + b + "\t" + c);
    }
}

class Son extends Father{
//    public int a = 10;
    public static int b = 20;
    public static final int c = 30;

    public void help() {
        System.out.println("\t" + b + "\t" + c);
    }
}
