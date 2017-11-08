package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {
		String s = "eceba";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int head = 0;
        int tail = 0;
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        while (tail < len) {
            if (map.size() < 3) {
                map.put(arr[tail], map.getOrDefault(arr[tail], 0) + 1);
                tail++;
            } else {
                while (map.size() > 2) {
                    if (map.get(arr[head]) == 1) {
                        map.remove(arr[head]);
                    } else {
                        map.put(arr[head], map.get(arr[head])-1);
                    }
                    head++;
                }
            }
            
            if (map.size() < 3){
                answer = Math.max(answer, tail-head);
            }
        }
        
        return answer;
    }
}
