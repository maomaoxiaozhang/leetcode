package question.q_136;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/3.
 * 数学思想：亦或，相同为0，不同为1
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = scanner.nextInt();
            }
            System.out.println(singleNumber(nums));
        }
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums){
            result ^= num;
        }
        return result;
    }
}
