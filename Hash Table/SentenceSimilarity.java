package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity {

	public static void main(String[] args) {
		String[] words1 = {"great","acting","skills"};
		String[] words2 = {"fine","painting","talent"};
		String[][] pairs = {{"great","fine"},
							{"drama","acting"},
							{"skills","talent"}};
		
		System.out.println(areSentencesSimilar(words1, words2, pairs));
	}

	public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;
        
        Map<String, Set<String>> map = new HashMap<>();
        
        for (int i=0; i<pairs.length; i++) {
            Set set1 = map.getOrDefault(pairs[i][0], new HashSet<String>());
            set1.add(pairs[i][1]);
            map.put(pairs[i][0], set1);
            Set set2 = map.getOrDefault(pairs[i][1], new HashSet<String>());
            set2.add(pairs[i][0]);
            map.put(pairs[i][1], set2);
        }
        
        for (int i=0; i<words1.length; i++) {
            String str1 = words1[i];
            String str2 = words2[i];
            
            if (!str1.equals(str2)) {
                Set set1 = map.getOrDefault(str1, new HashSet<String>());
                Set set2 = map.getOrDefault(str2, new HashSet<String>());
                
                if (!set1.contains(str2) && !set2.contains(str1))
                    return false;
            }
        }
        
        return true;
    }
}
