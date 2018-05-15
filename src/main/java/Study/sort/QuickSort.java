package Study.sort;

/**
 * Created by lenovo on 2017/10/24.
 * 若i == j：
 *      1.之前交换过，i必是比temp小的数
 *      2.未曾交换，i代表的就是temp，符合条件
 * 从右边开始是为了保证i停止的时候是站在 <= temp 的位置，最后再交换一次left和i的位置
 *
 * Arrays.sort()函数，对于基本数据类型，底层使用快排，对于非基本数据类型，底层使用归并
 * 为了考虑算法的稳定性，对于基本数据，相同值无差别，排序对位置没有要求，所以选择更加高效的快排；对于非基本数据类型，排序前后相等实例的相对位置不宜改变，所以选择稳定的归并排序
 */
public class QuickSort {
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int temp = nums[left], i = left, j = right;
        while (i != j) {
            while (nums[j] >= temp && i < j)
                j--;
            while (nums[i] <= temp && i < j)
                i++;
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[left] = nums[i];
        nums[i] = temp;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }
}
