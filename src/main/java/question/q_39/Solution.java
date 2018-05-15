package question.q_39;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/7.
 * dp也有重复性的问题
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] candidates = new int[n];
            for (int i = 0; i < n; i++){
                candidates[i] = scanner.nextInt();
            }
            int target = scanner.nextInt();
            System.out.println(combinationSum(candidates, target));
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        String[] dp = new String[target+1];
        dp[0] = ";";
        for(int i = 1; i <= target; i++){
            dp[i] = ";";
            for(int j = 0; j < candidates.length; j++){
                if(i == candidates[j])
                    dp[i] += String.valueOf(candidates[j]) + ";";
                else if(i > candidates[j] && !dp[i-candidates[j]].equals(";")){
                    String[] strings = dp[i-candidates[j]].split(";");
                    for(String string : strings){
                        if(!string.equals("")){
                            string += "," + String.valueOf(candidates[j]) + ";";
                            dp[i] += string;
                        }
                    }
                }
            }
        }
        String[] strings = dp[target].split(";");
        List<List<Integer>> result = new LinkedList<>();
        for(String string : strings){
            List<Integer> list = new LinkedList<>();
            String[] str = string.split(",");
            for(String s : str)
                list.add(Integer.valueOf(s));
            result.add(list);
        }
        return result;
    }
}
