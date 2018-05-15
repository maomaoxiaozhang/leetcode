package Study.proxy.JDKTest;

public class Test {
    public static void main(String[] args) {
        imple imp = new imple();
        proxy pro = new proxy();
        interf res = (interf) pro.bind(imp);
        System.out.println(res.help(1, 2));
    }
}
