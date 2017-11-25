package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = {"foo","bar"};
		List<Integer> ans = findSubstring(s, words);
		
		for (int n : ans) {
			System.out.println(n);
		}
	}

	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();
        int wordLen = words[0].length();
        String[] arr = new String[s.length()/wordLen];
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> dict = new HashMap<>();
        int count = 0;
        if (s.length()%wordLen != 0)
            return answer;
        
        for (int i=0, j=0; i<s.length(); i=i+wordLen, j++) {
            arr[j] = s.substring(i, i+wordLen);
        }
        
        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0)+1);
        }
        
        int head = 0;
        int tail = 0;
        
        while (tail < arr.length) {
            if (dict.containsKey(arr[tail])) {
            	if (map.getOrDefault(arr[tail], 0) < dict.get(arr[tail])) {
            		map.put(arr[tail], map.getOrDefault(arr[tail], 0)+1);
            		count++;
            	} else {
            		while (head < tail) {
            			map.put(arr[head], map.get(arr[head])-1);
            			count--;
                        head++;
                        if (arr[head-1].equals(arr[tail])) {
                        	map.put(arr[tail], map.get(arr[tail])+1);
                        	count++;
                            break;
                        }
                    }
            	}
                
                if (count == words.length) {
                    answer.add(head*wordLen);
                    map.put(arr[head], map.get(arr[head])-1);
                    count--;
                    head++;
                }
                tail++;
            } else {
                tail++;
                head = tail;
                map = new HashMap<>();
                count = 0;
            }
        }
        
        return answer;
    }
}
