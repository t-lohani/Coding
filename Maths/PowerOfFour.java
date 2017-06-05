/*
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4. 
 * */

package maths;

public class PowerOfFour {

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(64));
	}

	public static boolean isPowerOfFour(int num) {
        if(num==0)
            return false;
        if(num==1)
            return true;
            
        return (Math.log(num)/Math.log(4))%1.0==0;
    }
}
