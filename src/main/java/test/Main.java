package test;

import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String str = in.next().trim();
            help(str);
        }
    }

    public static void help(String str) {
        if (str.equals("()")){
            System.out.println("No");
            return;
        }else {
            int sum = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    sum++;
                }else {
                    sum--;
                    min = Math.min(min, sum);
                }
            }
            if (min >= -1)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

}
     