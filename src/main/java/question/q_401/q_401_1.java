package question.q_401;

import java.util.ArrayList;
import java.util.List;

/*
 * 测试：
 * 回溯法表示1、2、4、8、16、32的组合情况
 */

public class q_401_1 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		List<Integer> matrix = new ArrayList<>();
		List<List<Integer>> answer = new ArrayList<>();
		traceback(arr, matrix, answer, 0, arr.length);
		for(int i = 0; i < answer.size(); i++){
			System.out.println("第" + i + "个解为：" +answer.get(i));
		}
	}
	
	public static void traceback(int[] arr, List<Integer>matrix, List<List<Integer>>answer, int i, int n){
		if(i == n){
			if(isValid(matrix, arr)){
				answer.add(new ArrayList<Integer>(matrix));
//				return;
			}
		}
		else{
			for(int j = 0; j < 2; j++){
				matrix.add(j);
				if(isValid(matrix, arr)){
					traceback(arr, matrix, answer, i+1, n);
				}
				matrix.remove(matrix.size()-1);
			}
		}
	}
	
	public static boolean isValid(List<Integer> matrix, int[] arr){
		boolean ans = true;
		int sum = 0;
		for(int i = 0; i < matrix.size(); i++){
			if(matrix.get(i) == 1){
				sum += arr[i];
			}
		}
		if(sum > 100){
			ans = false;
		}
		return ans;
	}

}
