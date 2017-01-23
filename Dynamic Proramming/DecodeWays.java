/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 * */

package dynamicprogramming;

public class DecodeWays {

	public static void main(String[] args) {
		String str = "12432323";
		System.out.println(numDecodings(str));
	}

	public static int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        char[] chArr = s.toCharArray();
        int[] intArr = new int[chArr.length+1];
        intArr[intArr.length-1] = 1;
        intArr[intArr.length-2] = chArr[chArr.length-1] == '0' ? 0 : 1;
        
        for (int i=chArr.length-2; i>=0; i--) {
            if (chArr[i] == '0') {
                continue;
            }
            
            String temp = "" + chArr[i] + chArr[i+1];
            if (Integer.parseInt(temp) < 27) {
                intArr[i] = intArr[i+1]+intArr[i+2];
            } else {
                intArr[i] = intArr[i+1];
            }
        }
        
        return intArr[0];
    }
}
