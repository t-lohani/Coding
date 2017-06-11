/*
 *  Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion? 
 * */

package maths;

public class PowerOfThree {

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(233382));
	}

	public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
