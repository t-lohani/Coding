/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
 * */

package Strings;

public class ValidPallindrome {

	public static void main(String[] args) {
		String test = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(test));
	}
	
	public static boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if(!Character.isLetterOrDigit(s.charAt(i))) {
                ++j;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))) {
                --i;
                continue;
            }            
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } 
        }
        return true;
    }

}
