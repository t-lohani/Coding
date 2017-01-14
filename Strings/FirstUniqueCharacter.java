/*
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * */

package strings;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));
	}
	
	public static int firstUniqChar(String s) {
        int[] hash = new int[26];
        char[] chArr = s.toCharArray();
        
        for (int i=0; i<chArr.length; i++) {
            hash[chArr[i]-'a']++;
        }
        
        for (int i=0; i<chArr.length; i++) {
            if (hash[chArr[i]-'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }

}
