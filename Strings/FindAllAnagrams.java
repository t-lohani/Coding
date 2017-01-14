/*
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.
 * */

package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

	public static void main(String[] args) {
		List<Integer> ans = new ArrayList<>();
		String s = "abab";
		String p = "ab";
		ans = findAnagrams(s, p);
		
		for (int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		
	}

	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        int[] bench = new int[26];
        int[] check = new int[26];
        
        for (int i=0; i<p.length(); i++) {
            bench[p.charAt(i)-'a']++;
            check[s.charAt(i)-'a']++;
        }
        
        int ind = 0;
        
        while (ind + p.length() <= s.length()) {
            if (Arrays.equals(bench, check)) {
                answer.add(ind);
            }
            
            check[s.charAt(ind)-'a']--;
            if (ind + p.length() < s.length()) {
                check[s.charAt(ind + p.length())-'a']++;
            }
            ind++;
        }
        
        return answer;
    }
}
