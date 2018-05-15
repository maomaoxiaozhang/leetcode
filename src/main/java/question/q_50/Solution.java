package question.q_50;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/4.
 * 超时：用二分法
 * 注意：Integer.MIN_VALUE = -2147483648；Integer.MAX_VALUE = 2147483647，两者相邻，需将最大值、最小值单独考虑
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            double x = scanner.nextDouble();
            int n = scanner.nextInt();
            myPow(x, n);
        }
    }

    public static double myPow(double x, int n){
        if (n == 0)
            return 1;
        if (n < 0){
            if (n == Integer.MIN_VALUE){
                x = 1/x;
                return x*myPow(x, Integer.MAX_VALUE);
            }else {
                n = -n;
                x= 1/x;
            }
        }
        return (n%2==0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
