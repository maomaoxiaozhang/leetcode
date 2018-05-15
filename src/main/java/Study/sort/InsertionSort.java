package Study.sort;

/**
 * Created by lenovo on 2017/10/24.
 * 插入排序，交换每次只针对两个数，插入是将一个目标数插入一堆有序数之间，参考打牌，每次获得一张新牌插入有序牌之间
 * O（n^2）
 * 稳定
 *
 * 问题在于插入为顺序比较，可优化为二分查找
 */
public class InsertionSort {
    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int get = nums[i], j = i-1;
            while (j >= 0 && nums[j] > get) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = get;
        }
    }
}
