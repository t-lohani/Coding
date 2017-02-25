/*
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * */

package maths;

public class ArrangeCoins {

	public static void main(String[] args) {
		System.out.println(arrangeCoins(3338283));
	}
	
	public static int arrangeCoins(int n) {
        int answer = 0;
        int req = 1;
        
        while (req <= n) {
            n = n - req;
            req++;
            answer++;
        }
        
        return answer;
    }

}
