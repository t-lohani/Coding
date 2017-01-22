/*
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * */

package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
	
	public static void main(String[] args) {
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6};
		int k = 3;
		List<int[]> ans = kSmallestPairs(nums1, nums2, k);
		
		for (int i=0; i<ans.size(); i++) {
			System.out.print("[" + ans.get(i)[0] + "," + ans.get(i)[1] + "]");
		}
	}
	
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<int[]> answer = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return answer;
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        
        for (int i=0; i<nums1.length && i<k; i++) {
            queue.add(new Pair(0, nums1[i], nums2[0]));
        }
        
        for (int i=0; i<k && !queue.isEmpty(); i++) {
            Pair popped = queue.remove();
            answer.add(new int[]{popped.num1, popped.num2});
            
            if (popped.ind2 < nums2.length-1) {
                int idx = popped.ind2+1;
                queue.add(new Pair(idx, popped.num1, nums2[idx]));
            }
        }
    
        return answer;
    }
}

class Pair implements Comparable<Pair> {
    int ind2;
    int num1, num2;
    
    public Pair(int index, int a, int b) {
        ind2 = index;
        num1 = a;
        num2 = b;
    }
    
    public int compareTo(Pair pair) {
        return (this.num1+this.num2) - (pair.num1+pair.num2);
    }
}
