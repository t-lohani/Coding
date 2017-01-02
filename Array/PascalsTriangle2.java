/*
 * Given an index k, return the kth row of the Pascal's triangle.
 * */

package array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

	public static void main(String[] args) {
		List<Integer> answer = new ArrayList<>();
		int rowIndex = 5;
		
		answer = getRow(rowIndex);
		
		for (int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}
	
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int curr[] = new int[rowIndex + 1];
        int prev[] = new int[rowIndex + 1];
        prev[0] = 1;
    
        for(int row = 1; row <= rowIndex; row++) {
            curr[0] = 1;
            curr[row] = 1;
    
            for(int i = 1; i < row; i++)
                curr[i] = prev[i] + prev[i - 1];
    
            int[] swap = curr;
            curr = prev;
            prev = swap;
        } 
    
        for(int i = 0; i <= rowIndex; i++)
            res.add(prev[i]);
    
        return res;
    }

}
