/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
 * */

package dynamicprogramming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(2);
		triangle.add(temp);
		temp = new ArrayList<>();
		temp.add(3);
		temp.add(4);
		triangle.add(temp);
		temp = new ArrayList<>();
		temp.add(6);
		temp.add(5);
		temp.add(7);
		triangle.add(temp);
		temp = new ArrayList<>();
		temp.add(4);
		temp.add(1);
		temp.add(8);
		temp.add(3);
		triangle.add(temp);
		
		System.out.println(minimumTotal(triangle));
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1)
            return triangle.get(0).get(0);
            
        Iterator<List<Integer>> itr = triangle.iterator();
        
        int grid[][] = new int[triangle.size()][];
        int i = 0;
        int j = 0;
        while(itr.hasNext()){
            List<Integer> list = itr.next();
            Iterator<Integer> itr2 = list.iterator();
            int temp[] = new int[list.size()];
            j =0;
            while(itr2.hasNext()){
                temp[j] = itr2.next();
                j++;
            }
            grid[i] = temp;
            i++;
        }
        
        int left, right;
        int max = Integer.MAX_VALUE;
        int fff = grid.length;
        for(i=1; i<fff; i++) {
            int[] qq = grid[i];
            int ppp = qq.length;
            int[] ooo = grid[i-1];
            for(j=0; j<ppp; j++) {
                int[] rrr = ooo;
                int[] yyy = qq;
                int vvv = rrr.length;
                if(j-1>=0 && j<vvv) {
                    left = rrr[j-1];
                    right = rrr[j];
                    yyy[j] = yyy[j] + Math.min(left, right);
                } else if(j-1>=0) {
                    yyy[j] = yyy[j] + rrr[j-1];
                } else if(j<vvv) {
                    yyy[j] = yyy[j] + rrr[j];
                }
            
                if(i==fff-1 && max>yyy[j]) {
                    max = yyy[j];
                }
                
            }
        }
        
        return max;
    }
}
