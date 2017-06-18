/*
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * */

package maths;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(43834));
	}

	public static boolean isPerfectSquare(int num) {
        int i = 1;
        
        while(num>0) {
            num = num - i;
            i = i+2;
        }
        
        return num==0;
    }
}
