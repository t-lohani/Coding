/*
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * */

package sorting;

import java.util.Arrays;

public class RelativeRanks {
	
	public static void main(String[] args) {
		int[] nums = {4,5,1,2,3};
		String[] answer = findRelativeRanks(nums);
		
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
    public static String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        String[] answer = new String[len];
        MedalNode[] arr = new MedalNode[len];
        
        if (nums.length == 0) {
            return answer;
        }
        
        for (int i=0; i<len; i++) {
            arr[i] = new MedalNode(nums[i], i);
        }
        
        Arrays.sort(arr);
        
        if (len > 0) {
            answer[arr[0].ind] = "Gold Medal";
        }
        
        if (len > 1) {
            answer[arr[1].ind] = "Silver Medal";
        }
        
        if (len > 2) {
            answer[arr[2].ind] = "Bronze Medal";
        }
        
        for (int i=3; i<len; i++) {
            answer[arr[i].ind] = (i+1) + "";
        }
        
        return answer;
    }
}

class MedalNode implements Comparable<MedalNode> {
    int val;
    int ind;
    
    public MedalNode(int val, int ind) {
        this.val = val;
        this.ind = ind;
    }
    
    public int compareTo(MedalNode node) {
        return node.val - this.val;
    }
}