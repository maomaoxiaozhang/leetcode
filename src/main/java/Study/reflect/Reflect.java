package Study.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by lenovo on 2018/1/2.
 * field（属性）也有本身的set、get方法，但是，如果属性设置为private，必须拆封装才能访问；而method（方法）设为public即可
 */
public class Reflect {

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("Study.reflect.Reflect$Father");
        Object object = klass.newInstance();
        Method get = klass.getMethod("getI");
        System.out.println(get.invoke(object));

        Method set = klass.getMethod("setI", int.class);
        set.invoke(object, 2);
        System.out.println(get.invoke(object));

        //要拆封装
        Field i = klass.getDeclaredField("i");
        i.setAccessible(true);
        i.set(object, 5);
        System.out.println(i.get(object));
    }

    static class Father{
        public Father() {
        }

        private int i;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}
