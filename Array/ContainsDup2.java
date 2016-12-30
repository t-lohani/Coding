/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 * */

package array;

import java.util.ArrayList;
import java.util.Collections;

public class ContainsDup2 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        ArrayList<Node> arrList = new ArrayList<>();
        Node temp;
        for (int i=0; i<nums.length; i++) {
            temp = new Node(nums[i], i);
            arrList.add(temp);
        }
        
        Collections.sort(arrList);
        
        for (int i=0; i<arrList.size()-1; i++) {
            int j = 1;
            while ((i+j<arrList.size()) && arrList.get(i).value == arrList.get(i+j).value) {
                if (Math.abs(arrList.get(i).index - arrList.get(i+j).index) <= k) {
                    return true;
                }
                j++;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
    	int nums[] = {1,2,2,4,5,2,7,8};
    	int gap = 1;
    	
    	System.out.println(containsNearbyDuplicate(nums, gap));
	}
}

class Node implements Comparable {
    int value;
    int index;
    
    public Node (int val, int ind) {
        value = val;
        index = ind;
    }
    
    public int compareTo (Object ob) {
        Node node = (Node) ob;
        return this.value - node.value;
    }
}