package question.q_401;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * n皇后问题
 */

public class q_401_2 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入皇后的数量：");
		int n = in.nextInt();
		List<Integer> matrix = new ArrayList<Integer>();
		List<List<Integer>> answer = new ArrayList<>();
		traceback(0, n, matrix, answer);
		for(int i = 0; i < answer.size(); i++){
			System.out.println("第" + (i+1) + "种情况为：");
			matrix = answer.get(i);
			for(int j = 0; j < n; j++){
				int loc = matrix.get(j);
				for(int k = 0; k < loc; k++){
					System.out.print("0   ");
				}
				System.out.print("1   ");
				for(int k = loc+1; k < n; k++){
					System.out.print("0   ");
				}
				System.out.println("\n");
			}
		}
	}
	
	public static void traceback(int i, int n, List<Integer> matrix, List<List<Integer>> answer){
		if(i == n){
			if(isValid(matrix)){
				answer.add(new ArrayList<Integer>(matrix));
			}
		}
		else{
			//遍历n种情况
			for(int j = 0; j < n; j++){
				matrix.add(j);
				if(isValid(matrix)){
					traceback(i+1, n, matrix, answer);
				}
				//不论成功与否都要回溯
				matrix.remove(matrix.size()-1);
			}
		}
	}
	
	public static boolean isValid(List<Integer> matrix){
		boolean ans = true;
		for(int i = 0; i < matrix.size(); i++){
			for(int j = i+1; j < matrix.size(); j++){
				//同列或者同对角线
				if(matrix.get(i) == matrix.get(j) || (i+matrix.get(j) == (j+matrix.get(i))) || (i+matrix.get(i) == (j+matrix.get(j)))){
					ans = false;
				}
			}			
		}
		return ans;
	}

}
