package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		
		System.out.println(wordBreak(s, wordDict));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        
        for (String word : wordDict) {
            set.add(word);
        }
        
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        
        for (int i=1; i<dp.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len];
    }
}
