package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

	public static void main(String[] args) {
		String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
		System.out.println(alienOrder(words));
	}

	public static String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        StringBuilder ret = new StringBuilder();
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        int[] degree = new int[26];
        int count = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degree[c - 'a'] == 0) {
                    count++;
                    degree[c - 'a'] = 1;
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            char[] curr = words[i].toCharArray(), next = words[i + 1].toCharArray();
            int len = Math.min(curr.length, next.length);
            for (int j = 0; j < len; j++) {
                if (curr[j] != next[j]) {
                    if (!map.containsKey(curr[j]))
                        map.put(curr[j], new HashSet<Character>());
                    if (map.get(curr[j]).add(next[j]))
                        degree[next[j] - 'a']++;
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<Character>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 1) {
                q.offer((char)('a' + i));
            }
        }
        while (!q.isEmpty()) {
            char c = q.poll();
            ret.append(c);
            if (map.containsKey(c)) {
                for (char ch : map.get(c)) {
                    if (--degree[ch - 'a'] == 1) q.offer(ch);
                }
            }
        }
        
        if (ret.length() != count) return "";
        return ret.toString();
    }
}
