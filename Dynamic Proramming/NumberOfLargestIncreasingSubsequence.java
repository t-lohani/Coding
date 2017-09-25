package dynamicprogramming;

public class NumberOfLargestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = {-1,3,1,6,3,8,9,3,6,1,7,4,8,6,9,10};
		System.out.println(findNumberOfLIS(nums));
	}

	public static int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int answer = 0;
        int max = 0;
        int[] count = new int[len];
        int[] ways = new int[len];
        
        for(int i=0; i<len; i++) {
        	count[i] = 1;
        	ways[i] = 1;
            for(int j=0; j<i ; j++) {
                if(nums[i] > nums[j]){
                    if(count[i] == count[j] + 1){
                    	ways[i] += ways[j];
                    }
                    if(count[i] < count[j] + 1){
                    	count[i] = count[j] + 1;
                    	ways[i] = ways[j];
                    }
                }
            }
            if(max == count[i]) {
            	answer += ways[i];
            }
            if(max < count[i]){
                max = count[i];
                answer = ways[i];
            }
        }
        return answer;
    }
}
