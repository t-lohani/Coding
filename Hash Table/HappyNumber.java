/*
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1

 * */

package hashtable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

	public static Set store = new HashSet<Integer>();
    public static int sum;
    public static boolean isHappy(int n) {
        if(n==0)
            return false;
        if(n==1)
            return true;
        
        sum = 0;    
        sum = squareSum(n);
        
        if(sum==1)
            return true;
        else {
            if(store.add(sum))
                return isHappy(sum);
            else
                return false;
        }
    }
    
    public static int squareSum(int num) {
        if(num<10)
            sum = sum + (int)Math.pow(num, 2);
        else
            sum = sum + (int)Math.pow(num%10, 2) + squareSum(num/10);
            
        return sum;
    }
}
