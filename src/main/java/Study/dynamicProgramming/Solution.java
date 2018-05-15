package Study.dynamicProgramming;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/9/29.
 * 学习学习，社会社会
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] w = new int[n];
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                w[i] = scanner.nextInt();
                v[i] = scanner.nextInt();
            }
            int sum = scanner.nextInt();
//            System.out.println(process(w, v, n, sum));
//            System.out.println(process2(w, v, n, sum));
            int[][] dp = process(w, v, n, sum);
            int i = n-1;
            int j = sum;
            System.out.println(dp[i][j]);
            //倒推求路径
            for (; i >= 0; i--){
                //还是把第一个物品/第0行单拎出来
                if (i == 0){
                    if (dp[i][j] == v[i])
                        System.out.println(w[i] + "\t" + v[i]);
                }else if (dp[i][j] > w[i]){
                    //大于才有机会，否则不处理
                    if (dp[i][j] != dp[i-1][j]){
                        //路径隐藏在这里，j只是背包此时的重量，只需考虑w[i]是否装即可
                        System.out.println(w[i] + "\t" + v[i]);
                        j -= w[i];
                    }
                }
            }
        }
    }
    static int[][] process(int[] w, int[] v, int n, int sum) {
        int[][] dp = new int[n][sum + 1];
        for (int i = 1; i <= sum; i++) {
            if (i >= w[0]) {
                dp[0][i] = v[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - w[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }
    static int process2(int[] w, int[] v, int n, int sum) {
        int[] dp = new int[sum + 1];
        for (int i = 1; i <= sum; i++) {
            if (i >= w[0]) {
                dp[i] = v[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = sum; j >=1; j--) {
                if (j >= w[i]) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }
        }
        return dp[sum];
    }
}
