/*
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 * */

package strings;

public class DetectCapital {

	public static void main(String[] args) {
		String word = "USA";
		System.out.println(detectCapitalUse(word));
	}
	
	public static boolean detectCapitalUse(String word) {
        
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        
        boolean small;
        char[] chArr = word.toCharArray();
        if (isCaps(chArr[0]) && isCaps(chArr[1])) {
            small = false;
        } else if (isCaps(chArr[0]) && isSmall(chArr[1])) {
            small = true;
        } else if (isSmall(chArr[0]) && isSmall(chArr[1])) {
            small = true;
        } else {
            return false;
        }
        
        for (int i=2; i<chArr.length; i++) {
            if ((small && isCaps(chArr[i])) || (!small && isSmall(chArr[i]))) {
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean isCaps (char ch) {
        return (ch>=65 && ch<=90);
    }
    
    public static boolean isSmall (char ch) {
        return (ch>=97 && ch<=122);
    }

}
