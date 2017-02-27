/*
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:

    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space. 
 * */

package hashtable;

import java.util.HashSet;

public class WordPattern {

	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog cat cat dog";
		
		System.out.println(wordPattern(pattern, str));
	}

	public static boolean wordPattern(String pattern, String str) {
        if(str.length()==0)
            return false;
            
        String splitArray[] = str.split(" ");
        
        if(pattern.length()!=splitArray.length)
            return false;
            
        HashSet<Character> hash1 = new HashSet<Character>();
        HashSet<String> hash2 = new HashSet<String>();
        
        for(int i=0; i<pattern.length(); i++) {
            if(hash1.add(pattern.charAt(i))!=hash2.add(splitArray[i]))
                return false;
        }
        
        return true;
    }
}
