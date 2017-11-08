package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		List<String> ans = wordBreak(s, wordDict);
		
		for (String str : ans) {
			System.out.println(str);
		}
	}

	static Set<String> set = new HashSet<>();
    
    public static List<String> wordBreak(String s, List<String> wordDict) {
        for (String str : wordDict) {
            set.add(str);
        }
        
        return doDFS(s, new HashMap<String, LinkedList<String>>());
    }
    
    public static List<String> doDFS(String str, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(str))
            return map.get(str);
        
        LinkedList<String> res = new LinkedList<>();
        if(str.length() == 0) {
            res.add("");
            return res;
        }
        
        for (String word : set) {
            if (str.startsWith(word)) {
                List<String> remaining = doDFS(str.substring(word.length()), map);
                for(String sub : remaining) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        
        map.put(str, res);
        return res;
    }
}
