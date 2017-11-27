package unionfind;

import java.util.HashMap;
import java.util.Map;

public class SentenceSimilarity2 {
	public static void main(String[] args) {
		String[] words1 = {"great","acting","skills"};
		String[] words2 = {"fine","drama","talent"};
		String[][] pairs = {{"great","good"},{"fine","good"},{"drama","acting"},{"skills","talent"}};
		
		System.out.println(areSentencesSimilarTwo(words1, words2, pairs));
	}
	
	public static boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;
        
        Map<String, String> map = new HashMap<>();
        
        for (String[] pair : pairs) {
            String str1 = pair[0];
            String str2 = pair[1];
            
            if (!map.containsKey(str1) && !map.containsKey(str2)) {
                map.put(str1, str1);
                map.put(str2, str1);
            } else if (map.containsKey(str1) && map.containsKey(str2)) {
                String parent1 = findParent(str1, map);
                String parent2 = findParent(str2, map);
                
                map.put(parent1, parent2);
            } else if (map.containsKey(str1)) {
                map.put(str2, str1);
            } else if (map.containsKey(str2)) {
                map.put(str1, str2);
            }
        }
        
        for (int i=0; i<words1.length; i++) {
            String str1 = words1[i];
            String str2 = words2[i];
            
            if (!str1.equals(str2)) {
                String parent1 = findParent(str1, map);
                String parent2 = findParent(str2, map);
                if (parent1 == null || parent2 == null || !parent1.equals(parent2))
                    return false;
            }
        }
        
        return true;
    }
    
    public static String findParent(String str, Map<String, String> map) {
        if (!map.containsKey(str))
            return null;
        
        while (!str.equals(map.get(str))) {
            str = map.get(str);
        }
        return str;
    }
}
