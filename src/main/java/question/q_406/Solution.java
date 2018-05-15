package question.q_406;

/**
 * Created by lenovo on 2017/10/5.
 * 根据0出现的次数划分情况即可
 * 机智的方法：叠乘法，两次遍历
 */
public class Solution {
    public static void main(String[] args) {

    }

    //product为叠乘值
    public static int[] productExceptSelf(int[] nums){
        int[] res = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++){
            res[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = nums.length-1; i >= 0; i--){
            res[i] = res[i] * product;
            product *= nums[i];
        }
        return res;
    }
}
