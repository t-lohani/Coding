/*
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:

    The given integer is guaranteed to fit within the range of a 32-bit signed integer.
    You could assume no leading zero bit in the integer’s binary representation.

Example 1:

Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:

Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

 * */

package bitmanipulation;

public class NumberCompliment {

	public static void main(String[] args) {
		System.out.println(findComplement(2327));
	}

	public static int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        
        boolean start = false;
        int answer = 0;
        int mask;
        
        for (int i=31; i>=0; i--) {
            mask = 1 << i;
            if ((num & mask) == mask) {
                if (!start) {
                    start = true;
                }
            } else if ((num & mask) != mask && start) {
                answer += mask;
            }
        }
        
        return answer;
    }
}
