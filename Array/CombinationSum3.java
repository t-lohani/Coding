package array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

	public static void main(String[] args) {
		combinationSum3(3, 9);
		
		for (int i=0; i<answer.size(); i++) {
			for (int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> answer = new ArrayList<>();
    
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> sub = new ArrayList<Integer>();
        int[] candidates = new int[9];
        for(int i=0; i<candidates.length; i++) {
            candidates[i] = i+1;
        }
        
        combine(candidates, n, 0, sub, k);
        
        return answer;
    }
    
    public static void combine(int[] arr, int target, int index, List<Integer> subArr, int k) {
        if(index==arr.length || target<=0) {
            if(target==0 && subArr.size()==k) {
                List<Integer> addList = new ArrayList<Integer>();
                for(int i=0; i<subArr.size(); i++) {
                    addList.add(subArr.get(i));
                }
                answer.add(addList);
            }
        } else {
            subArr.add(arr[index]);
            combine(arr, target-arr[index], index+1, subArr, k);
            subArr.remove(subArr.size()-1);
            combine(arr, target, index+1, subArr, k);
        }
    }
}
