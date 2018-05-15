package question.q_169;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/5.
 * 注意：等保证出现次数大于 n/2，否则无法判断
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        majorityElement(nums);
    }

    public static int majorityElement(int[] nums){
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == major){
                count++;
            }else {
                count--;
                if (count < 0){
                    major = nums[i];
                    count = 1;
                }
            }
        }
        return major;
    }
}
