package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Subsequences {

	public static void main(String[] args) {
		String str = "abc";
		subseqs(str);
		
		String[] answer = set.toArray(new String[set.size()]);
		Arrays.sort(answer);
		
		for (int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	static Set<String> set = new HashSet<>();
	
    public static void subseqs(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        generate(arr, 0, sb);
    }
    
    public static void generate(char[] arr, int pos, StringBuilder sb) {
    	if (pos == arr.length)
    		return;
    	
    	sb.append(arr[pos]);
    	String s1 = new String(sb);
    	if (s1.length() != 0)
    		set.add(s1);
    	generate(arr, pos+1, sb);
    	
    	sb.deleteCharAt(sb.length()-1);
    	String s2 = new String(sb);
    	if (s2.length() != 0)
    		set.add(s2);
    	generate(arr, pos+1, sb);
    }
}
