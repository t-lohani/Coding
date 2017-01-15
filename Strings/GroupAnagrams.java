/*
 * Given an array of strings, group anagrams together.
 * */

package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> ans = groupAnagrams(strs);
		
		for (List<String> list : ans) {
			for (String str : list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        if (strs.length == 0) {
            return answer;
        }
        
        for (int i=0; i<strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            
            List<String> list;
            if (!map.containsKey(key)) {
                list = new ArrayList<>();
            } else {
                list = map.get(key);
            }
            
            list.add(strs[i]);
            map.put(key, list);
        }
        
        for (List<String> lst : map.values()) {
            answer.add(lst);
        }
        
        return answer;
    }

}
