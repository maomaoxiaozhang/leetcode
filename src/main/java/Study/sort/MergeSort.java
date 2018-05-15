package Study.sort;

/**
 * Created by lenovo on 2017/10/24.
 * 归并排序，时间复杂度O（nlogn）
 * 稳定，间隔指的是相邻连续数组，希尔步长指的是跳数
 */
public class MergeSort {
    public static void mergeSortRecursion(int[] nums, int left, int right) {
        if (left == right)
            return;
        int mid = (left + right)/2;
        mergeSortRecursion(nums, left, mid);
        mergeSortRecursion(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    public static void mergeSortIteration(int[] nums) {
        int left, mid, right;
        for (int i = 1; i < nums.length; i *= 2) {
            left = 0;
            while (left + i < nums.length) {
                mid = left + i - 1;
                right = mid + i < nums.length ? mid + i : nums.length-1;
                merge(nums, left, mid, right);
                left = right + 1;
            }
        }
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int i = left, j = mid+1, index = 0;
        while (i <= mid && j <= right)
            temp[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        while (i <= mid)
            temp[index++] = nums[i++];
        while (j <= right)
            temp[index++] = nums[j++];
        for (int k = 0; k < temp.length; k++)
            nums[left++] = temp[k];
    }
}
