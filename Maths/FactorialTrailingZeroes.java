/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * */

package maths;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		System.out.println(10);
	}

	public static int trailingZeroes(int n) {
        int trailingCount = 0;
        
        while(n>=5) {
            n/=5;
            trailingCount += n;
        }
        
        return trailingCount;
    }
}
