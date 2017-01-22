/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.
 * */

package bitmanipulation;

public class TotalHammingDistance {

	public static void main(String[] args) {
		int[] nums = {14, 4, 2, 7, 5};
		System.out.println(totalHammingDistance(nums));
	}
	
	public static int totalHammingDistance(int[] nums) {
        int answer = 0;
        
        for (int i=0; i<32; i++) {
            int ones = 0;
            int mask = 1<<i;
            
            for (int j=0; j<nums.length; j++) {
                if ((nums[j]&mask) != 0) {
                    ones++;
                }
            }
            
            answer += ones*(nums.length-ones);
        }
        
        return answer;
    }

}
