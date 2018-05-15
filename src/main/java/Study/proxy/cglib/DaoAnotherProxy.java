package Study.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lenovo on 2018/1/25.
 */
public class DaoAnotherProxy implements MethodInterceptor{
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("startTime = " + System.currentTimeMillis());
        methodProxy.invokeSuper(o, objects);
        System.out.println("endTime = " + System.currentTimeMillis());

        return o;
    }
}
