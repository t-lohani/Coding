/*
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * */

package bitmanipulation;

import java.util.HashSet;

public class MaximumXor {

	public static void main(String[] args) {
		int[] nums = {3, 10, 5, 25, 2, 8};
		System.out.println(findMaximumXOR(nums));
	}
	
	public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        
        for (int i=31; i>=0; i--) {
            HashSet<Integer> hashSet = new HashSet<>();
            mask = mask | (1 << i);
            for (int j=0; j<nums.length; j++) {
                hashSet.add(nums[j] & mask);
            }
            
            int temp = max | (1 << i);
            for (int val : hashSet) {
                if (hashSet.contains(val^temp)) {
                    max = temp;
                    break;
                }
            }
        }
        
        return max;
    }

}
