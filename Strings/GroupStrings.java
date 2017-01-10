package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupStrings {

	public static void main(String[] args) {
		String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z","pqr","ace" ,"qsu"};
//		String[] strings = {"abc","bcd"};
		List<List<String>> ans = groupStrings(strings);
		
		for (int i=0; i<ans.size(); i++) {
			for (int j=0; j<ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder key;
        int offset;
        
        for (int i=0; i<strings.length; i++) {
        	offset = strings[i].charAt(0)-'a';
            key = new StringBuilder();
            for (int j=0; j<strings[i].length(); j++) {
            	char c = (char) (strings[i].charAt(j) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key.append(c);
            }

            if (!map.containsKey(key.toString())) {
            	List<String> list = new ArrayList<String>();
            	map.put(key.toString(), list);
            }
            map.get(key.toString()).add(strings[i]);
        }
        
        List<List<String>> answer = new LinkedList<>(map.values());
        return answer;
    }
}
