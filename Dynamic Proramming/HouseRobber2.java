package dynamicprogramming;

public class HouseRobber2 {

	public static void main(String[] args) {
		int[] nums = {3,4,7,2,4,6,2,5,7,9,6,3,4,6,7};
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        
        return Math.max(rob(nums, 0, nums.length-1), rob(nums, 1, nums.length));
    }
    
    public static int rob(int[] nums, int start, int end) {
        int include = 0, exclude = 0;
        for (int j = start; j < end; j++) {
            int temp = include;
            include = exclude + nums[j];
            exclude = Math.max(exclude, temp);
        }
        return Math.max(include, exclude);
    }
}
