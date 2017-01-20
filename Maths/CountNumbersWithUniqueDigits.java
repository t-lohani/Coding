/*
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 * */

package maths;

public class CountNumbersWithUniqueDigits {

	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(5));
	}

	public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        
        if (n > 10) {
            n = 10;
        }
        
        int[] answer = new int[n];
        answer[0] = 10;
        
        for (int i=1; i<n; i++) {
            int count = i;
            int multiply = 1;
            int num = 9;
            while(count>0) {
                multiply = multiply * num;
                count--;
                num--;
            }
            multiply = multiply * 9;
            answer[i] = answer[i-1] + multiply;
        }
        
        return answer[answer.length-1];
    }
}
