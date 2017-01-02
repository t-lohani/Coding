/*
 * Given numRows, generate the first numRows of Pascal's triangle.
 * */

package array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		List<List<Integer>> answer = new ArrayList<>();
		int numRows = 5;
		answer = generate(numRows);
		
		for (int i=0; i<answer.size(); i++) {
			for (int j=0; j<answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
    	if (numRows <= 0)
    		return result;
     
    	ArrayList<Integer> pre = new ArrayList<Integer>();
    	pre.add(1);
    	result.add(pre);
     
    	for (int i = 2; i <= numRows; i++) {
    		ArrayList<Integer> cur = new ArrayList<Integer>();
     
    		cur.add(1); //first
    		for (int j = 0; j < pre.size() - 1; j++) {
    			cur.add(pre.get(j) + pre.get(j + 1)); //middle
    		}
    		cur.add(1);//last
     
    		result.add(cur);
    		pre = cur;
    	}
     
    	return result;
    }

}
