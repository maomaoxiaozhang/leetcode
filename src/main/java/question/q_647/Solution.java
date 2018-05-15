package question.q_647;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/4.
 * 思路：遍历回文“中间点”，向两边扩；找回文子串而不是判断
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length(); j++){
                boolean flag = true;
                for (int m = i, n = j; m < n; m++, n--){
                    if (s.charAt(m) != s.charAt(n)){
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    count++;
            }
        }
        return count;
    }
}
