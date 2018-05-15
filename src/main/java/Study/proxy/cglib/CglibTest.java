package Study.proxy.cglib;

import Study.proxy.jdk.BookFacadeImpl;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * Created by lenovo on 2018/1/25.
 */
public class CglibTest {
    public static void main(String[] args) {

//        DaoProxy daoProxy = new DaoProxy();
//        DaoAnotherProxy daoAnotherProxy = new DaoAnotherProxy();
//
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(Dao.class);
//        enhancer.setCallbacks(new Callback[]{daoProxy, daoAnotherProxy, NoOp.INSTANCE});
//        enhancer.setCallbackFilter(new DaoFilter());
//        enhancer.setInterceptDuringConstruction(false);
//
//        Dao dao = (Dao) enhancer.create();
//        dao.update();
//        dao.select();

        BookFacadeImpl bookFacade = new BookFacadeImpl();
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl instance = (BookFacadeImpl) cglib.getInstance(bookFacade);
        instance.addBook();
    }
}
