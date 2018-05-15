package Study.dynamicProgramming;

/**
 * Created by lenovo on 2018/1/31.
 * 背包问题
 * 有两种方式：1.提前初始化；2.状态压缩（无需，因为第一个物品的上一行为全0）
 */
public class PacketsTest {
    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4, 5};
        int[] v = {2, 1, 4, 5, 3};
        int[] c = {1, 2, 3, 4, 5};
        int sum = 10;

//        packet_1(w, v, sum);
//        packet_2(w, v, sum);
//        packet_3(w, v, sum);
        packet_4(w, v, sum);
    }

    /*
    ==============================================0-1背包===============================================================
    状态转移方程是一样的，所以核心一致
    12
     */
    //行代表的是物品，列代表的是重量
    public static void packet_1(int[] w, int[] v, int sum) {
        int[][] dp = new int[w.length][sum+1];
        for (int i = 1; i <= sum; i++) {
            if (i >= w[0])
                dp[0][i] = v[0];
        }
        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = j >= w[i] ? Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]) : dp[i-1][j];
            }
        }
        System.out.println(dp[w.length-1][sum]);
    }

    //状态压缩；从右往左，相当于取上一行状态
    public static void packet_2(int[] w, int[] v, int sum) {
        int[] dp = new int[sum+1];
        for (int i = 0; i < w.length; i++) {
            for (int j = sum; j >= 1; j--) {
                dp[j] = j >= w[i] ? Math.max(dp[j], dp[j-w[i]]+v[i]) : dp[j];
            }
        }
        System.out.println(dp[sum]);
    }

    /*
    ==============================================完全背包==============================================================
    核心的状态转移方程只有一个地方不一样而已
    不取则为上一层；取则为同层
    20
     */
    public static void packet_3(int[] w, int[] v, int sum) {
        int[][] dp = new int[w.length][sum+1];
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = i/w[0]*v[0];
        }
        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = j >= w[i] ? Math.max(dp[i-1][j], dp[i][j-w[i]]+v[i]) : dp[i-1][j];
            }
        }
        System.out.println(dp[w.length-1][sum]);
    }

    public static void packet_4(int[] w, int[] v, int sum) {
        int[] dp = new int[sum+1];
        for (int i = 0; i < w.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[j] = j >= w[i] ? Math.max(dp[j], dp[j-w[i]]+v[i]) : dp[j];
            }
        }
        System.out.println(dp[sum]);
    }

    /*
    ==============================================多重背包==============================================================
     */
}
