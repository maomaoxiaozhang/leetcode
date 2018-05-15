package question.q_279;

/**
 * Created by lenovo on 2017/10/5.
 * 思路：动态规划，记录过程，减少计算
 * 机智的答案：结果职位1、2、3、4，分情况即可。。。。。
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static int numSquares(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++){
            int num = 1 + dp[i-1];
            for (int k = 2; k*k <= i; k++){
                int temp = dp[i-k*k] + 1;
                if (temp < num)
                    num = temp;
            }
            dp[i] = num;
        }
        return dp[n];
    }
}
