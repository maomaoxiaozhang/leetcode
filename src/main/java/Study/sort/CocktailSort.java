package Study.sort;

/**
 * Created by lenovo on 2017/10/24.
 * 鸡尾酒排序法，冒泡排序的优化版，每次遍历先将最大值排出，再寻找最小值，如此往复
 * O（n^2）
 * 稳定
 */
public class CocktailSort {
    public static void cocktailSort(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (nums[i] > nums[i+1])
                    swqp(nums, i, i+1);
            }
            right--;
            for (int i = right; i > left; i--) {
                if (nums[i] < nums[i-1])
                    swqp(nums, i, i-1);
            }
            left++;
        }
    }

    public static void swqp(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
