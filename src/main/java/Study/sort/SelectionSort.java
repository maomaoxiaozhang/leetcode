package Study.sort;

/**
 * Created by lenovo on 2017/10/24.
 * 选择排序，每次遍历记录最小值位置
 * 不稳定
 */
public class SelectionSort {
    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[min] > nums[j])
                    min = j;
            }
            swap(nums, i, min);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
