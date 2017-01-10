package Strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

	public static void main(String[] args) {
		List<String> strs = new ArrayList<>();
		strs.add("");
		
		List<String> answer = decode(encode(strs));
		
		for (int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}
	
	// Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }

}
