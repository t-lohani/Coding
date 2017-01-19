/*
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.

Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.

We keep repeating the steps again, alternating left to right and right to left, until a single number remains.

Find the last number that remains starting with a list of length n.
 * */

package maths;

public class EliminationGame {

	public static void main(String[] args) {
		System.out.println(lastRemaining(9));
	}

	public static int lastRemaining(int n) {
        boolean left = true;
        int step = 1;
        int head = 1;
        int remaining = n;
        
        while (remaining > 1) {
            if (left || remaining%2 == 1) {
                head = head + step;
            }
            
            step = step * 2;
            remaining = remaining/2;
            left = !left;
        }
        
        return head;
    }
}
