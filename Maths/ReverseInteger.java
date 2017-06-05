/*
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321 
 * */

package maths;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = 123;
		System.out.println(reverse(x));
	}

	public static int reverse(int x) {
        long reversedNum = 0;

        long input_long = x;
    
        while (input_long != 0)
        {
            reversedNum = reversedNum * 10 + input_long % 10;
            input_long = input_long / 10;
        }
    
        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE)
        {
            return 0;
        }
        return (int)reversedNum;
    }
}
