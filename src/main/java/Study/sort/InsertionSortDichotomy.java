package Study.sort;

/**
 * Created by lenovo on 2017/10/24.
 * 二分插入排序，插入的时候找到get应该在的位置，统一右移
 */
public class InsertionSortDichotomy {
    public static void insertionSortDichotomy(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int get = nums[i], left = 0, right = i-1;
            while (left <= right) {
                int mid = (left + right)/2;
                if (nums[mid] > get)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            for (int j = i-1; j >= left; j--) {
                nums[j+1] = nums[j];
            }
            nums[left] = get;
        }
    }
}
