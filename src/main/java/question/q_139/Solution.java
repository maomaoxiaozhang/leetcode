package question.q_139;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/3.
 * 存疑：不是状态转移方程
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            List<String> wordDict = new LinkedList<>();
            for (int i = 0; i < n; i++){
                wordDict.add(scanner.next());
            }
            String s= scanner.next();
            System.out.println(process(s, wordDict));
        }
    }

    public static boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        boolean[] flag = new boolean[n+1];
        flag[0] = true;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < i; j++){
                if (flag[j] && wordDict.contains(s.substring(j, i))){
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[n];
    }

    //模拟背包问题
    public static boolean process(String s, List<String> wordDict){
        if (wordDict.size() == 0 && s.length() != 0)
            return false;
        int n = s.length();
        boolean[][] flag = new boolean[wordDict.size()][n+1];
        for (int i = 1; i <= n; i++){
            if (wordDict.get(0).equals(s.substring(0, i)))
                flag[0][i] = true;
        }
        for (int i = 0; i < wordDict.size(); i++)
            flag[i][0] = true;
        for (int i = 1; i < wordDict.size(); i++){
            for (int j = 1; j <= n; j++){
                if (j >= wordDict.get(i).length()){
                    String str = s.substring(0, j);
                    if (str.contains(wordDict.get(i)) && flag[i-1][j-wordDict.get(i).length()]){
                        flag[i][j] = true;
                    }
                }
            }
        }
        return flag[wordDict.size()-1][n];
    }
}
