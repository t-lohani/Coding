/*
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.
 * */

package Strings;

public class RansomNote {

	public static void main(String[] args) {
		System.out.println(canConstruct("aa", "aab"));
	}
	
	public static boolean canConstruct(String ransomNote, String magazine) {
        char[] chArr1 = ransomNote.toCharArray();
        char[] chArr2 = magazine.toCharArray();
        
        int[] hashArray = new int[26];
        
        for(int i=0; i<chArr1.length; i++) {
            hashArray[chArr1[i]-'a']++;
        }
        
        for(int i=0; i<chArr2.length; i++) {
            hashArray[chArr2[i]-'a']--;
        }
        
        for(int i=0; i<26; i++) {
            if(hashArray[i]>0)
                return false;
        }
        
        return true;
    }

}
