package question.q_155;

import java.util.Stack;

/**
 * Created by lenovo on 2017/10/4.
 * 用一个栈来实现另一个栈。。。。。。
 * 终点在最小值的实时变化，先存再变，这样 pop = 现最小值（存入值）- 前最小值
 * 或者空间换时间，每次更新最小值时将前一个最小值存入，取数时判断，否则多取一次
 */
public class Solution {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(2147483647);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.push(-2147483648);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

    }

    static class MinStack{
        private Stack stack;
        private long min;

        public MinStack(){
            stack = new Stack();
        }

        public void push(int x){
            if (stack.size() == 0){
                stack.push(0);
                min = x;
            }else {
                stack.push(x - min);
                if (x < min)
                    min = x;
            }
        }

        public void pop(){
            if (stack.size() == 0)
                return;
            else{
                long pop = (long)stack.pop();
                if (pop < 0)
                    min = min - pop;
            }
        }

        public int top(){
            long pop = (long)stack.peek();
            if (pop < 0)
                return (int) min;
            else {
                return (int) (pop+min);
            }
        }

        public int getMin(){
            return (int) min;
        }
    }
}
