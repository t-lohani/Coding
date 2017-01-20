/*
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * */

package maths;

public class AddDigits {

	public static void main(String[] args) {
		System.out.println(addDigits(78));
	}

	public static int addDigits(int num) {
        if (num==0) return 0;
        return num%9==0?9:num%9;
    }
}
