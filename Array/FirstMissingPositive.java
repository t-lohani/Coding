package array;

public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] nums = {2,1};
		System.out.println(firstMissingPositive(nums));
	}

	public static int firstMissingPositive(int[] nums) {
		int len = nums.length;
        
        for(int i=0; i<len; ++i) {
            while(nums[i]>0 && nums[i]<=len && nums[nums[i]-1]!=nums[i]) {
                int temp = nums[i];
                int ind = nums[i]-1;
                nums[i] = nums[nums[i]-1];
                nums[ind] = temp;
            }
        }
        
        for(int i=0; i<len; ++i) {
            if(nums[i]!=i+1) {
                return i+1;
            }
        }
        
        return len+1;
    }
}
