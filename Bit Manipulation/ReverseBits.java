/*
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it? 
 * */

package bitmanipulation;

public class ReverseBits {

	public static void main(String[] args) {
		int n = 43261596;
		System.out.println(reverseBits(n));
	}

	public static int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse |= ((n >>> i) & 1) << (31 - i);
        }
        return reverse;
    }
}
