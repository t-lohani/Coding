/*
 * Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * */

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> ans = permute(nums);
		
		for (int i=0; i<ans.size(); i++) {
			for (int j=0; j<ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static ArrayList<List<Integer>> answer = new ArrayList<>();
    
    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length==0)
            return answer;
        generate(nums, 0);
        return answer;
    }
    
    public static void generate(int[] arr, int index) {
        if(index==arr.length) {
            ArrayList<Integer> list = new ArrayList();
            for(int i=0; i<arr.length; i++)
                list.add(arr[i]);
                
            answer.add(list);
        }
        
        for(int i=index; i<arr.length; i++) {
            swap(index, i, arr);
            generate(arr, index+1);
            swap(index, i, arr);
        }
    }
    
    public static void swap(int i1, int i2, int[] arr) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
