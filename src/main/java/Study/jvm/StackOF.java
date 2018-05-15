package Study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/1/4.
 */
public class StackOF {
    private int stacklength = 1;
    public void stackLeak() {
        stacklength++;
        stackLeak();
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        for (; ;) {
            int[] array = new int[1000];
            list.add(array);
        }
    }
}
