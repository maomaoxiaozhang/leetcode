package Study.sort;

/**
 * Created by lenovo on 2017/10/25.
 * 计数排序法，不属于比较排序，实际上用数组下标隐含了顺序
 * 稳定：反向填充数组，填充后将对应数字递减，可确保稳定性
 * 一通操作
 */
public class CountingSort {
    public static void countingSort(int[] nums) {
        int max = nums[0];
        for (int i : nums)
            max = Math.max(max, i);
        int[] count = new int[max+1];
        for (int i : nums)
            count[i]++;
        for (int i = 1; i < count.length; i++)
            count[i] += count[i-1];
        int[] result = new int[nums.length];
        for (int i = nums.length-1; i >= 0; i--)
            result[(count[nums[i]]--)-1] = nums[i];
        for (int i = 0; i < nums.length; i++)
            nums[i] = result[i];
    }
}
