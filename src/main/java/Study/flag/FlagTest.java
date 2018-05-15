package Study.flag;

/*
荷兰国旗问题
类比快排的思想，3个指针，left：左边有序的右边一个；cur：游标，遍历；right：右边有序的左边一个
 */

public class FlagTest {
    public static void main(String[] args) {
        char[] array = {'Z', '3', '5', 'o', 'q', 'X', 'Y'};
        help(array);
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }

    //顺序为数字 -- 小写 -- 大写
    public static void help(char[] array) {
        int left = 0, right = array.length-1, cur = left;
        while (cur <= right) {
            if (Character.isDigit(array[cur])) {
                char temp = array[cur];
                for (int j = cur; j > left; j++) {
                    array[j-1] = array[j];
                }
                array[left] = temp;
                left++;
                cur++;
            }else if (Character.isLowerCase(array[cur])) {
                cur++;
            }else {
                char temp = array[cur];
                for (int j = cur; j < array.length-1; j++)
                    array[j] = array[j+1];
                array[array.length-1] = temp;
                right--;
            }
        }
    }
}
