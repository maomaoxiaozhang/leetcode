package Study.proxy.jdk;

/**
 * Created by lenovo on 2018/1/25.
 */
public class JdkTest {
    public static void main(String[] args) {
        BookFacadeImpl bookFacadeImpl = new BookFacadeImpl();
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookFacade = (BookFacade) proxy.bind(bookFacadeImpl);
        bookFacade.addBook();
    }
}
