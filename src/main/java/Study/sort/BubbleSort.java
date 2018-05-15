package Study.sort;

/**
 * Created by lenovo on 2017/10/24.
 * 冒泡排序
 * 正常时间复杂度为O（n^2），若添加标记位flag表示一次遍历有无交换，则最优时间复杂度为O（n）
 * 稳定
 */
public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums.length-1-i; j++) {
                if (nums[j-1] > nums[j]) {
                    swap(nums, j-1, j);
                    flag = 1;
                }
            }
            if (flag == 0)
                break;
            flag = 0;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
