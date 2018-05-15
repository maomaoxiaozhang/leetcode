package Study.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by lenovo on 2018/1/25.
 */
public class DaoFilter implements CallbackFilter{
    @Override
    public int accept(Method method) {
        if (method.getName().equals("select"))
            return 0;
        else
            return 1;
    }
}
