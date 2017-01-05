/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.
 * */

package Strings;

public class LengthOfLastWord {

	public static void main(String[] args) {
		String test = "Hello World";
		System.out.println(lengthOfLastWord(test));
	}
	
	public static int lengthOfLastWord(String s) {
        if(s==null || s.length() == 0)
            return 0;
     
        int result = 0;
        int len = s.length();
     
        boolean flag = false;
        for(int i=len-1; i>=0; i--){
            char c = s.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z')){
                flag = true;
                result++;
            }else{
                if(flag)
                    return result;
            }
        }
     
        return result;
    }

}
