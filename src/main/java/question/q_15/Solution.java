package question.q_15;

import java.util.*;

/**
 * Created by lenovo on 2017/10/3.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = scanner.nextInt();
            }
            List<List<Integer>> result = threeSum(nums);
            for (List<Integer> list : result){
                System.out.println(list);
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> except = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]++));
            }else {
                map.put(nums[i], 1);
            }
        }

        for (int a : map.keySet()){
            if (map.get(a) >= 3){
                if (a == 0){
                    List<Integer> list = new LinkedList<>();
                    list.add(0);
                    list.add(0);
                    list.add(0);
                    result.add(list);
                }
                map.put(a, 2);
            }
            if (map.get(a) == 2){
                int b = a;
                int c = 0-a-b;
                if (map.containsKey(c)){
                    List<Integer> list = new LinkedList<>();
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    result.add(list);
                }
                map.put(a, 1);
            }
            if (map.get(a) == 1){
                except.add(a);
                HashMap<Integer, Integer> has = new HashMap<>();
                for (int b : map.keySet()){
                    int c = 0-a-b;
                    if (map.containsKey(c)){
                        List<Integer> list = new LinkedList<>();
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        result.add(list);
                        has.put(c, map.get(c));
                        has.put(b, map.get(b));
                        map.remove(c);
                        map.remove(b);
                    }
                }
                map.putAll(has);
            }
        }
        return result;
    }
}
