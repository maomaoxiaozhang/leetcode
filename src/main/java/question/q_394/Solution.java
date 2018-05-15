package question.q_394;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/7.
 * 分情况讨论，将数字、字母剥离出来即可
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            System.out.println(decodeString(s));
        }
    }

    public static String decodeString(String s) {
        if((s.charAt(0)-'a' >= 0) && ('z'-s.charAt(0) >= 0)){
            int loc = index_2(s);
            if(loc == -1){
                return s;
            }else{
                return s.substring(0, loc) + decodeString(s.substring(loc));
            }
        }else{
            int loc_1 = s.indexOf('[');
            int num = Integer.valueOf(s.substring(0, loc_1));
            int loc_2 = index_1(s, loc_1);
            String rest = decodeString(s.substring(loc_1+1, loc_2));
            String result = "";
            for(int i = 0; i < num; i++){
                result += rest;
            }
            return result + decodeString(s.substring(loc_2+1));
        }
    }

    public static int index_1(String s, int i){
        int count = 0;
        for(; i < s.length(); i++){
            if(s.charAt(i) == '[')
                count++;
            if(s.charAt(i) == ']')
                count--;
            if(count == 0)
                break;
        }
        return i;
    }

    public static int index_2(String s){
        int loc = -1;
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i)-'0' >= 0) && ('9'-s.charAt(i) >= 0)){
                loc = i;
                break;
            }
        }
        return loc;
    }
}
