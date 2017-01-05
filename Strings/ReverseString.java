/*
 * Write a function that takes a string as input and returns the string reversed.
 * */

package Strings;

public class ReverseString {

	public static void main(String[] args) {
		String test = "Bloomberg";
		test = reverseString(test);
		System.out.println(test);
	}
	
	public static String reverseString(String s) {
        char[] chArr = s.toCharArray();
        int head = 0;
        int tail = chArr.length-1;
        char ch;
        
        while (head <= tail) {
            ch = chArr[head];
            chArr[head] = chArr[tail];
            chArr[tail] = ch;
            
            head++;
            tail--;
        }
        
        s = new String(chArr);
        return s;
    }
}
