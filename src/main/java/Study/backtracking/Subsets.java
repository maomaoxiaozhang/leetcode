package Study.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2017/11/20.
 * 有重复：
 *      总个数 = 非重复数的子集数（2^n） * （重复数个数+1）
 * 一次遍历，选取第一个要取的数的位置，递归定义（之前都不必再考虑）
 * 每次都考虑当前第一个选取的数的loc
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2};
        subsets(nums);
    }

    public static void subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> list_1 = new ArrayList<>();
        List<List<Integer>> list_2 = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        backtrack_1(list_1, new ArrayList<>(), nums, 0);
        backtrack_2(list_2, new ArrayList<>(), nums, 0);
        System.out.println(list);
        System.out.println(list_1);
        System.out.println(list_2);
    }

    /*
    无重复元素
    考虑的是第一个取的元素，i+1
     */
    public static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int k) {
        /*
        记录已有情况
        []
         */
        list.add(new ArrayList<>(temp));
        for (int i = k; i < nums.length; i++) {
            temp.add(nums[i]);
            /*
            k -- bums.length-1 间第一个采纳的数
            注意此时前面的数忽略不计，已经考虑过了
             */
            backtrack(list, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }

    /*
    无重复元素，使用二叉树方法
    每次考虑一层的情况，才是 k+1
     */
    public static void backtrack_1(List<List<Integer>> list, List<Integer> temp, int[] nums, int k) {
        if (k == nums.length) {
            list.add(new ArrayList<>(temp));
        }else {
            //取
            temp.add(nums[k]);
            backtrack_1(list, temp, nums, k+1);
            temp.remove(temp.size()-1);
            //不取
            backtrack_1(list, temp, nums, k+1);
        }
    }

    /*
    有重复元素
    无法用二叉树的方法，因为二叉树每层都是2种可能，这里重复元素有 n+1 种可能
     */
    public static void backtrack_2(List<List<Integer>> list, List<Integer> temp, int[] nums, int k) {
        list.add(new ArrayList<>(temp));
        /*
        i记录第一个取得数，之前都不必再考虑（递归定义）
         */
        for (int i = k; i < nums.length; i++) {
            /*
            将重复的数视为一次出现，取或不取，i > k 保证了重复数有n次机会选择（出现0、1、2、3 ... n次）
            只有前面选了后面才有机会！
            将 i > k 换为 i > 0 则变为没有重复数字的子集
             */
            if (i > k && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            backtrack_2(list, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
