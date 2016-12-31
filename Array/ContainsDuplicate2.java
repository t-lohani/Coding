/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 * */

package array;

import java.util.Arrays;

public class ContainsDuplicate2 {

	public static void main(String[] args) {
		int[] nums = {1,1,3,4,5,6,6,3,1,7,4,9,12,5,7,4};
		int k = 0;
		System.out.println(containsNearbyDuplicate(nums, k));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1)
            return false;
            
        NodeArr[] nodeArr = new NodeArr[nums.length];
        
        for (int i=0; i<nums.length; i++) {
        	NodeArr temp = new NodeArr(nums[i], i);
            nodeArr[i] = temp;
        }
        
        Arrays.sort(nodeArr);
        
        for (int i=1; i<nodeArr.length; i++) {
            if (nodeArr[i].data == nodeArr[i-1].data && Math.abs(nodeArr[i].index - nodeArr[i-1].index) <= k) {
                return true;
            }
        }
        
        return false;
    }
}

class NodeArr implements Comparable<NodeArr> {
    int data, index;
    
    public NodeArr (int data, int index) {
        this.data = data;
        this.index = index;
    }
    
    public int compareTo(NodeArr node) {
        
        return this.data - node.data;
    }
}
