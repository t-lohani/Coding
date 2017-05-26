/*
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * */

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	public static void main(String[] args) {
		int n = 6;
		List<Integer> answer = grayCode(n);
		
		for (int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}

	public static List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        int terms = 1 << (n);
        //int terms = (int)Math.pow(2,n);
        int count = 0;
        
        while(ans.size()<terms) {
            int addVal = 1 << count;
            //int addVal = (int)Math.pow(2,count);
            for(int i=ans.size()-1; i>=0; i--) {
                ans.add(ans.get(i)+addVal);
            }
            count++;
        }
        return ans;
    }
}
