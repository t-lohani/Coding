/*
 * A magical string S consists of only '1' and '2' and obeys the following rules:

The string S is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string S itself.

The first few elements of string S is the following: S = "1221121221221121122��"

If we group the consecutive '1's and '2's in S, it will be:

1 22 11 2 1 22 1 22 11 2 11 22 ......

and the occurrences of '1's or '2's in each group are:

1 2	2 1 1 2 1 2 2 1 2 2 ......

You can see that the occurrence sequence above is the S itself.

Given an integer N as input, return the number of '1's in the first N number in the magical string S.

Note: N will not exceed 100,000.
 * */

package maths;

public class MagicalString {

	public static void main(String[] args) {
		System.out.println(magicalString(10000));
	}
	
	public static int magicalString(int n) {
        if (n == 0) {
            return 0;
        }
        
        if (n > 0 && n < 4) {
            return 1;
        }
        
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;
        int count = 1;
        boolean addOne = true;
        
        int i = 3;
        int j = 2;
        
        while (i < n) {
            if (addOne) {
                int loop = arr[j];
                while (loop > 0) {
                    arr[i++] = 1;
                    loop--;
                    count++;
                    if (i >= n)
                        break;
                }
                j++;
                addOne = false;
            } else {
                int loop = arr[j];
                while (loop > 0) {
                    arr[i++] = 2;
                    loop--;
                    if (i >= n)
                        break;
                }
                j++;
                addOne = true;
            }
        }
        return count;
    }

}
