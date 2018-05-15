package question.q_78;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/7.
 * dp的核心思想是记录状态，i表示到此为止，可减少递归的部分
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
            System.out.println(subsets(nums));
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<List<Integer>>> result = new LinkedList<>();
        List<Integer> list_00 = new LinkedList<>();
        List<Integer> list_01 = new LinkedList<>();
        list_01.add(nums[0]);
        List<List<Integer>> list_2 = new LinkedList<>();
        list_2.add(list_00);
        list_2.add(list_01);
        result.add(list_2);
        for(int i = 1; i < n; i++){
            list_2 = result.get(i-1);
            List<List<Integer>> has = new LinkedList<>();
            for(List<Integer> list : list_2){
                List<Integer> temp = new LinkedList<>();
                temp.addAll(list);
                temp.add(nums[i]);
                has.add(temp);
            }
            has.addAll(list_2);
            result.add(has);
        }
        return result.get(n-1);
    }
}
