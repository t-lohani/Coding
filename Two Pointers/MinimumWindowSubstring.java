package twopointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ANDENBCHRDAEBSIOBCGYGAV", "ABC"));
	}

	public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }

        int start = 0;
        int end = 0;
        int head = 0;
        int counter = t.length();
        int min = Integer.MAX_VALUE;
        int len = s.length();

        while (end < len) {
            if (map.getOrDefault(s.charAt(end), 0) > 0) {
                counter--;
            }
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)-1);
            end++;

            while (counter == 0) {
                if (end - start < min) {
                    head = start;
                    min = end - start;
                }
                map.put(s.charAt(start), map.get(s.charAt(start))+1);
                if (map.get(s.charAt(start)) > 0) {
                    counter++;
                }
                start++;
            }
        }
        
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head+min);
    }
}
