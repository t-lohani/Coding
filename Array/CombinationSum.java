/*
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
 * */

package array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		
		combinationSum(candidates, target);
		
		for (int i=0; i<answer.size(); i++) {
			for (int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> answer = new ArrayList<>();
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<Integer> sub = new ArrayList<Integer>();
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
            combine(arr, target-arr[index], index, subArr);
            subArr.remove(subArr.size()-1);
            combine(arr, target, index+1, subArr);
        }
    }

}
