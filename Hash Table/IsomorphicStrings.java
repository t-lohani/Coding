/*
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 * */

package hashtable;

import java.util.HashSet;

public class IsomorphicStrings {

	public static void main(String[] args) {
		String s = "paper";
		String t = "title";
		System.out.println(isIsomorphic(s, t));
	}

	public static boolean isIsomorphic(String s, String t) {
        
        HashSet<Character> hash1 = new HashSet<Character>();
        HashSet<Character> hash2 = new HashSet<Character>();
        
        char[] hashArray = new char[256];

        for(int i=0; i<s.length(); i++) {
            if(hashArray[s.charAt(i)]=='\u0000') {
                hashArray[s.charAt(i)] = t.charAt(i);
                if(hash1.add(s.charAt(i))!=hash2.add(t.charAt(i)))
                    return false;
            } else if(hashArray[s.charAt(i)]!=t.charAt(i))
                return false;
        }
        
        return true;
    }
}
