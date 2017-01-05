/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * */

package Strings;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] arrStr = {"cat", "carrom", "cat"};
		String answer = longestCommonPrefix(arrStr);
		System.out.println(answer);
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
            
        int minLen = Integer.MAX_VALUE;
        
        for(int i=0; i<strs.length; i++) {
            if(strs[i].length() < minLen)
                minLen = strs[i].length();
        }
        
        if(minLen==0)
            return "";
        
        StringBuilder strBld = new StringBuilder();
        strBld.append("");
        
        for(int i=0; i<minLen; i++) {
            char temp = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if(strs[j].charAt(i)!=temp)
                    return strBld.toString();
            }
            strBld.append(temp);
        }
        
        return strBld.toString();
    }

}
