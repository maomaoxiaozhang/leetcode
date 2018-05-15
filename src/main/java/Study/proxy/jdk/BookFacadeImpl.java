package Study.proxy.jdk;

/**
 * Created by lenovo on 2018/1/25.
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("addBook");
    }
}
