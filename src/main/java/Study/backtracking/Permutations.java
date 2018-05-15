package Study.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2017/11/21.
 *
 * 两个的通解都是先求解第一个能加入的位置，然后递归；每次只在添加时才递归
 *
 * 因为是全排列，所以可以用temp的长度表示是否递归结束，每次从头至尾遍历，找到第一个未采取数字
 * 确保相同元素存在线性关系（只能按顺序选取），即去除相同元素的排列数目（3！/2！）
 */
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack_2(list, new ArrayList<>(), nums, used);
        return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i]))
                    continue;
                temp.add(nums[i]);
                backtrack(list, temp, nums);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void backtrack_2(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        }else {
            for (int i = 0; i < nums.length; i++) {
                /*
                确保相同元素是以相应顺序依次选取，若前一个相同元素未选取，则自身不能选取（相同元素，确保存在线性关系，参照数学公式）
                修改只用前半判断，则为 n!
                 */
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1])
//                if (used[i])
                    continue;
                used[i] = true;
                temp.add(nums[i]);
                backtrack_2(list, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }




//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        backtrack(nums, list, 0);
//        return list;
//    }
//
//    public void backtrack(int[] nums, List<List<Integer>> list, int depth) {
//        if (depth == nums.length) {
//            List<Integer> tempList = new ArrayList<>();
//            for (int i = 0; i < nums.length; i++)
//                tempList.add(nums[i]);
//            list.add(tempList);
//        } else {
//            for (int i = depth; i < nums.length; i++) {
//                exchange(nums, i, depth);
//                backtrack(nums, list, depth+1);
//                exchange(nums, i, depth);
//            }
//        }
//    }
//
//    public void exchange(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
}
