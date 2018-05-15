package question.q_43;

/**
 * Created by lenovo on 2017/10/9.
 * 思路：
 *      1.非常巧妙，两个数相乘，至多为两位数：i+j 和 i+j+1
 *      2.从尾至头依次相乘
 *      3.每位上的冗余会被抹平
 *
 * 注意：每位上留下来的是 %，进位的是 /
 */
public class Solution {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.length();
        multiply("999", "999");
    }

    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
