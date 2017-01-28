/*
 * Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
 * */

package bitmanipulation;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(divide(159, 13));
	}

	public static int divide(int dividend, int divisor) {
        if (divisor==-1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }    
        
        long pdividend = Math.abs((long)dividend);
        long pdivisor = Math.abs((long)divisor);
        int result = 0;
        
        while (pdividend >=  pdivisor) {
            int shift = 0;
            while (pdividend >= (pdivisor << shift)) {
                shift++;
            }
            result += 1 << (shift-1);
            pdividend -= pdivisor << (shift-1);
        }
        if ((divisor < 0 && dividend < 0) || (divisor > 0 && dividend > 0)) {
            return result;
        }
        
        return -result;
    }
}
