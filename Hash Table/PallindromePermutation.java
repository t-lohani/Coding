/*
 * Given a string, determine if a permutation of the string could form a palindrome.
 * */

package hashtable;

public class PallindromePermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "aabbc";
		System.out.println(canPermutePalindrome(test));
	}
	
	public static boolean canPermutePalindrome(String s) {
        if (s.length() == 0)
            return true;
            
        int[] hashArr = new int[256];
        boolean oddEncountered = false;
        
        for (int i=0; i<s.length(); i++) {
            hashArr[s.charAt(i)]++;
        }
        
        for (int i=0; i<256; i++) {
            if (hashArr[i]%2==1) {
                if (oddEncountered)
                    return false;
                else
                    oddEncountered = true;
            }
        }
        
        return true;
    }

}
