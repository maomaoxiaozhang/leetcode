package Study.dynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/1.
 * 状态压缩无需初始化
 */
public class SolutionCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] w = new int[n];
            int[] v = new int[n];
            int[] c = new int[n];
            for (int i = 0; i < n; i++){
                w[i] = scanner.nextInt();
                v[i] = scanner.nextInt();
                c[i] = scanner.nextInt();
            }
            int sum = scanner.nextInt();
//            int[][] dp = process(w, v, n, sum);
//            process(w, v, n, sum);
//            process2(w, v, n, sum);
//            process3(dp, w, v, n, sum);
//            process4(w, v, n, sum);
//            int[][] dp = process5(w, v, n, sum);
//            process6(dp, w, v, n, sum);
//            List<Integer> newW = new LinkedList<>();
//            List<Integer> newV = new LinkedList<>();
//            for (int i = 0, count = 1; i < n; i++, count = 1){
//                while (c[i] > count){
//                    newW.add(count*w[i]);
//                    newV.add(count*v[i]);
//                    c[i] -= count;
//                    count = count * 2;
//                }
//                newW.add(c[i]*w[i]);
//                newV.add(c[i]*v[i]);
//            }
//            process7(newW, newV, sum);
//            process8(newW, newV, sum);
            process4(w, v, n, sum);
            process5(w, v, n, sum);
        }
    }

    /*
    动态规划
    0
    1 -- n-1; 1 -- sum
     */
    public static int[][] process(int[] w, int[] v, int n, int sum){
        int[][] dp = new int[n][sum+1];
        for (int i = 1; i <= sum; i++){
            if (i >= w[0])
                dp[0][i] = v[0];
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j <= sum; j++){
                if (j >= w[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n-1][sum]);
        return dp;
    }

    /*
    状态压缩
    1 -- n-1; sum -- 1
     */
    public static int[] process2(int[] w, int[] v, int n, int sum){
        int[] dp = new int[sum+1];
        for (int i = 1; i < n; i++){
            for (int j = sum; j >= 1; j--){
                if (j >= w[i]){
                    dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[sum]);
        return dp;
    }

    /*
    倒序求路径
    n-1 -- 1
    0
     */
    public static void process3(int[][] dp, int[] w, int[] v, int n, int sum){
        //基本数据类型传递的都是实参的拷贝，可随意使用
        for (n = n-1; n > 0; n--){
            if (dp[n][sum] != dp[n-1][sum]){
                System.out.println(w[n] + "\t" + v[n]);
                sum -= w[n];
            }
        }
        if (dp[n][sum] != 0)
            System.out.println(w[0] + "\t" + v[0]);
    }

    /*
    完全背包问题，状态压缩
    1 -- n-1; 1 -- sum
     */
    public static void process4(int[] w, int[] v, int n, int sum){
        int[] dp = new int[sum+1];
        for (int i = 0; i < n; i++){
            for (int j = 1; j <= sum; j++){
                if (j >= w[i]){
                    dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[sum]);
    }

    /*/
    完全背包问题
     */
    public static int[][] process5(int[] w, int[] v, int n, int sum){
        int[][] dp = new int[n][sum+1];
        for (int i = 1; i <= sum; i++){
            if (i >= w[0])
                dp[0][i] = dp[0][i-w[0]]+v[0];
        }
        for (int i = 1; i < n; i++){
            for (int j =1; j <= sum; j++){
                if (j >= w[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-w[i]]+v[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n-1][sum]);
        return dp;
    }

    /*/
    完全背包，倒序求路径
     */
    public static void process6(int[][] dp, int[] w, int[] v, int n, int sum){
        for (n = n-1; n > 0; n--){
            while (dp[n][sum] != dp[n-1][sum]){
                System.out.println(w[n] + "\t" + v[n]);
                sum -= w[n];
            }
        }
        while (dp[n][sum] != 0){
            System.out.println(w[n] + "\t" + v[n]);
            sum -= w[n];
        }
    }

    /*
    多重背包问题
    将重复度化为1，变为0-1背包问题
     */
    public static void process7(List<Integer> newW, List<Integer> newV, int sum){
        int n = newW.size();
        int[][] dp = new int[n][sum+1];
        for (int i = 1; i <= sum; i++){
            if (i >= newW.get(0))
                dp[0][i] = newV.get(0);
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j <= sum; j++){
                if (j >= newW.get(i)){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-newW.get(i)]+newV.get(i));
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n-1][sum]);
    }

    /*
    多重背包问题，状态压缩
     */
    public static void process8(List<Integer> newW, List<Integer> newV, int sum){
        int n = newW.size();
        int[] dp = new int[sum+1];
        for (int i = 1; i <= sum; i++){
            if (i >= newW.get(0))
                dp[i] = newV.get(0);
        }
        for (int i = 1; i < n; i++){
            for (int j = sum; j >= 1; j--){
                if (j >= newW.get(i))
                    dp[j] = Math.max(dp[j], dp[j-newW.get(i)]+newV.get(i));
            }
        }
        System.out.println(dp[sum]);
    }

}
