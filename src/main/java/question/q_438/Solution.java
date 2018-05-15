package question.q_438;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/5.
 * 判断两个字符串是否由相同字符组成：构建数组 int[26] 保存每个单词出现的次数，遍历--，为负不符
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            String p = scanner.next();
            findAnagrams(s, p);
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0, j = i+p.length(); j <= s.length(); i++, j++){
            String str = s.substring(i, j);
            if (decide(str, p))
                list.add(i);
        }
        return list;
    }

    public static boolean decide(String str, String p){
        int[] set = new int[26];
        for (int i = 0; i < p.length(); i++){
            set[p.charAt(i)-'a']++;
        }
        for (int i = 0; i < str.length(); i++){
            if ((--set[str.charAt(i)-'a']) < 0)
                return false;
        }
        return true;
    }

}
