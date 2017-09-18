package reservoirsampling;

import java.util.Random;

public class RandomPickIndex {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		RandomPickIndex rpi = new RandomPickIndex(nums);
		System.out.println(rpi.pick(2));
	}

	int[] nums;
    Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (random.nextInt(++count) == 0)
                result = i;
        }
        
        return result;
    }
}
