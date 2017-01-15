/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * */

package strings;

public class ValidAnagram {

	public static void main(String[] args) {
		String s = "anagram";
		String t = "gramaan";
		System.out.println(isAnagram(s, t));
	}

	public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        if (s.length() == 0) {
            return true;
        }
        
        int[] hash = new int[26];
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        
        for (int i=0; i<chS.length; i++) {
            hash[chS[i]-'a']++;
            hash[chT[i]-'a']--;
        }
        
        for (int i=0; i<hash.length; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}
