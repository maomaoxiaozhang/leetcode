package question.q_70;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/4.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(climbStairs(n));
        }
    }

    //递归，时间溢出
    public static int process(int n){
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else
            return process(n-1)+process(n-2);
    }

    public static int climbStairs(int n){
        if (n == 1)
            return 1;
        int[] steps = new int[n+1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i++){
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }
}
