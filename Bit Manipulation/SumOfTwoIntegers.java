/*
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * */

package bitmanipulation;

public class SumOfToIntegers {

	public static void main(String[] args) {
		System.out.println(getSum(10, 20));
	}

	public static int getSum(int a, int b) {
        if (a==0) return b;
        if (b==0) return a;
        
        int carry = 0;
        while (b != 0) {
            carry = a&b;
            a = a^b;
            b = carry<<1;
        }
        
        return a;
    }
}
