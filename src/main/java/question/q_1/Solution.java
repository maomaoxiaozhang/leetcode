package question.q_1;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/2.
 * 求数组内和为常数的索引
 * HashMap查找时间为常数，若只有一组符合，可存储为HashMap的形式，节约一层循环
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            int[] nums = new int[num];
            for (int i = 0; i < num; i++){
                nums[i] = scanner.nextInt();
            }
            int target = scanner.nextInt();
            System.out.println(twoSum(nums, target)[0] + "\t" + twoSum(nums, target)[1]);
        }
    }

    public static int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if ((nums[i]+nums[j]) == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
