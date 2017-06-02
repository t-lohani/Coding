/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n. 
 * */

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		int n = 4;
		int k = 3;
		List<List<Integer>> ans = combine(n, k);
		
		for (int i=0; i<ans.size(); i++) {
			for (int j=0; j<ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> answer = new ArrayList<>();
    
    public static List<List<Integer>> combine(int n, int k) {
        if(k==0)
            return answer;
            
        ArrayList<Integer> list = new ArrayList<Integer>();
        generate(1, n, k, list);
        
        return answer;
    }
    
    public static void generate(int num, int maxNum, int count, ArrayList<Integer> arrList) {

        if(count==0 || num>maxNum) {
            if(count==0) {
                ArrayList<Integer> newList = new ArrayList<Integer>();
            for(int i=0; i<arrList.size(); i++) {
                newList.add(arrList.get(i));
            }
            answer.add(newList);
            }
            return;
        }
        
        arrList.add(num);
        generate(num+1, maxNum, count-1, arrList);
        arrList.remove(arrList.size()-1);
        generate(num+1, maxNum, count, arrList);
    }
}
