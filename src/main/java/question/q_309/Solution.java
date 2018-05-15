package question.q_309;

/**
 * Created by lenovo on 2017/10/12.
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0)
            return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] -= prices[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        return max(dp[n-1][0], dp[n-1][1], dp[n-1][2]);
    }

    public static int max(int a, int b, int c){
        if(a > b){
            if(a > c)
                return a;
            return c;
        }else{
            if(b > c)
                return b;
            return c;
        }
    }
}
