package question.q_11;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/3.
 * 面积更大两种特点：最短边更长或间距更大
 * 两边逼近，较短边需更长！！
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] height = new int[n];
            for (int i = 0; i < n; i++){
                height[i] = scanner.nextInt();
            }
            System.out.println(maxArea(height));
        }
    }

    public static int maxArea(int[] height){
        int result = 0;
        int n = height.length;
        for (int i = 0, j = n-1; i < j;){
            int area = Math.min(height[i], height[j]) * (j-i);
            if (area > result)
                result = area;
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return result;
    }
}
