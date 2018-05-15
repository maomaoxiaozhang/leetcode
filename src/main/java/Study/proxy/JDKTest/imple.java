package Study.proxy.JDKTest;

public class imple implements interf{
    @Override
    public int help(int a, int b) {
        System.out.println("add");
        return a+b;
    }
}
