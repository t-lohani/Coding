package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LongestUncommonSubsequence2 {

	public static void main(String[] args) {
		String[] strs = {"aba", "cbc"};
		System.out.println(findLUSlength(strs));
	}

	public static int findLUSlength(String[] strs) {
        int len = strs.length;
        
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        
        for(int i=0; i<len; i++){
            boolean missMatchCount = false;
            for(int j=0; j<len; j++){
                if(i != j && isSubSequence(strs[i], strs[j])){
                    missMatchCount = true;
                }
            }
            
            if(!missMatchCount){
                return strs[i].length();
            }
        }
        
        return -1;
    }
    
    private static boolean isSubSequence(String s1, String s2){
        int idx = 0;
        for(char ch : s2.toCharArray()){
            if(idx < s1.length() && ch == s1.charAt(idx)){
                idx++;
            }
        }
        
        return idx == s1.length();
    }
}
