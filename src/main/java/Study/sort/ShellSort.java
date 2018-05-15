package Study.sort;

/**
 * Created by lenovo on 2017/10/24.
 * 希尔排序法，在插入排序法的基础上修改，每次遍历不同步长
 * 也称为递减增量排序
 * 不稳定
 */
public class ShellSort {
    public static void shellSort(int[] nums) {
        int shell = 0;
        while (shell <= nums.length) {
            shell = shell * 3 + 1;
        }
        while (shell >= 1) {
            for (int i = shell; i < nums.length; i++) {
                int get = nums[i], j = i-shell;
                while (j >= 0 && nums[j] > get){
                    nums[j+shell] = nums[j];
                    j = j - shell;
                }
                nums[j+shell] = get;
            }
            shell = (shell - 1)/3;
        }
    }
}
