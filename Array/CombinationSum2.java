/*
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
 * */

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		
		combinationSum2(candidates, target);
		
		for (int i=0; i<answer.size(); i++) {
			for (int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> answer = new ArrayList<>();
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> sub = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combine(candidates, target, 0, sub);
        
        return answer;
    }
    
    public static void combine(int[] arr, int target, int index, List<Integer> subArr) {
        if(index==arr.length || target<=0) {
            if(target==0) {
                List<Integer> addList = new ArrayList<Integer>();
                for(int i=0; i<subArr.size(); i++) {
                    addList.add(subArr.get(i));
                }
                answer.add(addList);
            }
        } else {
            subArr.add(arr[index]);
            combine(arr, target-arr[index], index+1, subArr);
            subArr.remove(subArr.size()-1);
            
            while(index+1<arr.length && arr[index]==arr[index+1])
                index++;
                
            combine(arr, target, index+1, subArr);
        }
    }

}
