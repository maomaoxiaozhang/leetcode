package Study.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2018/1/27.
 * 排列组合测试
 * 因为都是for 遍历，所以每个里面只需要递归一次即可
 */
public class Per_Sub {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3};
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
//        permutation_1(result, new ArrayList<>(), array);
//        permutation_2(result, new ArrayList<>(), array, new boolean[array.length]);
//        subset_1(result, new ArrayList<>(), array, 0);
        subset_2(result, new ArrayList<>(), array, 0);
        System.out.println(result);
    }

    /*
    =====================================================排列===========================================================
    排列所有元素必取，所以不需要深度k
    有重复时，排列保证按序取1遍（从0遍历，若与前者相同则前者必须取过才行）
     */
    //无重复数{1, 2, 3}, 3! = 6种
    public static void permutation_1(List<List<Integer>> result, List<Integer> temp, int[] array) {
        if (temp.size() == array.length)
            result.add(new ArrayList<>(temp));
        else {
            for (int i = 0; i < array.length; i++) {
                if (temp.contains(array[i]))
                    continue;
                temp.add(array[i]);
                permutation_1(result, temp, array);
                temp.remove(temp.size()-1);
            }
        }
    }

    //有重复数{1, 2, 2, 3}, 4!/2! = 12种
    public static void permutation_2(List<List<Integer>> result, List<Integer> temp, int[] array, boolean[] flag) {
        if (temp.size() == array.length)
            result.add(new ArrayList<>(temp));
        else {
            for (int i = 0; i < array.length; i++) {
                if (flag[i] == true || i > 0 && array[i] == array[i-1] && !flag[i-1])
                    continue;
                temp.add(array[i]);
                flag[i] = true;
                permutation_2(result, temp, array, flag);
                temp.remove(temp.size()-1);
                flag[i] = false;
            }
        }
    }

    /*
    =====================================================组合===========================================================
    有选择的，需要k指示深度，注意每次递归是 i+1
    有重复时，组合保证按序组合 n+1 次（从k遍历，每次只取第一个）
     */
    //无重复数，{1, 2, 3}，2^3 = 8种
    public static void subset_1(List<List<Integer>> result, List<Integer> temp, int[] array, int k) {
        result.add(new ArrayList<>(temp));
        for (int i = k; i < array.length; i++) {
            temp.add(array[i]);
            subset_1(result, temp, array, i+1);
            temp.remove(temp.size()-1);
        }
    }

    //有重复数，{1, 2, 2, 3}，2^2 * (2+1) = 12种
    public static void subset_2(List<List<Integer>> result, List<Integer> temp, int[] array, int k) {
        result.add(new ArrayList<>(temp));
        for (int i = k; i < array.length; i++) {
            if (i > k && array[i] == array[i-1])
                continue;
            temp.add(array[i]);
            subset_2(result, temp, array, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
