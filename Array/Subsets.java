/*
 * Given a set of distinct integers, nums, return all possible subsets.
 * */

package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		subsets(nums);
		
		for (int i=0; i<answer.size(); i++) {
			for (int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> answer = new ArrayList<>();
    
    public static List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> list = new LinkedList<Integer>();
        generate(nums, 0, list);
        
        return answer;
    }
    
    public static void generate(int[] numArr, int index, List<Integer> arrList) {
        
        if(index==numArr.length) {
            List<Integer> list = new LinkedList<Integer>();
            for(int i=0; i<arrList.size(); i++) {
                list.add(arrList.get(i));
            }
            answer.add(list);
            return;
        }
        arrList.add(numArr[index]);
        generate(numArr, index+1, arrList);
        arrList.remove(arrList.size()-1);
        generate(numArr, index+1, arrList);
    }
}
