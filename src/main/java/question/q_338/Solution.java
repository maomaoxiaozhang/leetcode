package question.q_338;

import java.util.Scanner;

/**
 * Created by lenovo on 2017/10/4.
 * n&(n-1)：每次讲n二进制中最右边一个1舍去
 * 数学思想：dp，每次移位加上i的末位
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            process(n);
        }
    }

    public static int[]countBits(int num){
        int[] bits = new int[num+1];
        for (int i = 0; i <= num; i++){
            int n = i;
            int count = 0;
            while (n != 0){
                n = n & (n-1);
                count++;
            }
            bits[i] = count;
        }
        return bits;
    }

    //dp的思想
    public static int[] process(int num){
        int[] bits = new int[num+1];
        bits[0] = 0;
        for (int i = 1; i <= num; i++){
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
