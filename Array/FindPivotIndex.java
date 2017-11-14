package array;

public class FindPivotIndex {
	
	public static void main(String[] args) {
		int[] nums = {1, 7, 3, 6, 5, 6};
		System.out.println(pivotIndex(nums));
	}
	
	public static int pivotIndex(int[] nums) {
        int left = 0;
        int right = 0;
        
        for (int i=0; i<nums.length; i++) {
            right += nums[i];
        }
        
        for (int i=0; i<nums.length; i++) {
            right -= nums[i];
            
            if (left == right) {
                return i;
            }
            
            left += nums[i];
        }
        
        return -1;
    }
}
