package question.q_401;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q_401 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<String> time;
		
		//i表示时针数，n-i表示分针数
		for(int i = 0; i < 5 && (n-i) >= 0 && (n-i) < 7; i++){
			List<Integer> matrix = new ArrayList<>();
			List<List<Integer>> hour = new ArrayList<>();
			traceback(i, 4, matrix, hour);
			List<List<Integer>> minute = new ArrayList<>();
			matrix.clear();
			traceback(n-i, 6, matrix, minute);
			int seq = 1;
			for(int j = 0; i < hour.size(); i++){
				int h = add(hour.get(j));
				for(int k = 0; k < minute.size(); k++){
					int m = add(minute.get(k));
					System.out.println("第" + seq + "种可能情况为：" + String.valueOf(h) + ":" + String.valueOf(m));
					seq++;
				}
			}
			
		}

	}
	
	public static void traceback(int i, int n, List<Integer> matrix, List<List<Integer>> answer){
		if(matrix.size() == i){
			if(isValid(matrix, n)){
				answer.add(new ArrayList<Integer>(matrix));
			}
		}
		else{
			for(int j = 0; j < 2; j++){
				matrix.add(j);
				if(isValid(matrix, n)){
					traceback(i+1, n, matrix, answer);
				}
				matrix.remove(matrix.size()-1);
			}
		}
	}
	
	public static boolean isValid(List<Integer> matrix, int n){
		boolean ans = true;
		int[] arr = {1,2,4,8,16,32};
		int sum = add(matrix);
		
		switch (n) {
		case 4:
			if(sum >= 12){
				ans = false;
			}
			break;
		case 6:
			if(sum >= 60){
				ans = false;
			}
			break;

		default:
			break;
		}
		
		return ans;
	}
	
	public static int add(List<Integer> matrix){
		int sum = 0;
		int[] arr = {1,2,4,8,16,32};
		for(int i = 0; i < matrix.size(); i++){
			sum += arr[i];
		}
		return sum;
	}

}
