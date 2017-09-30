package hashtable;

import java.util.ArrayList;
import java.util.List;

public class MagicDictionary {

	public static void main(String[] args) {
		MagicDictionary md = new MagicDictionary();
		String[] dict = {"hello", "leetcode"};
		md.buildDict(dict);
		System.out.println(md.search("helll"));
	}

	static List<String> list;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        list = new ArrayList<>();
    }
    
    /** Build a dictionary through a list of words */
    public static void buildDict(String[] dict) {
        for(String str:dict) {
            list.add(str);
        }
    }
        
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public static boolean search(String word) {
        for(int i=0; i<list.size(); i++) {
            String str=list.get(i);
            if(str.length() != word.length())
                continue;
            
            int count=0;
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j) != word.charAt(j))
                    count++;
            }
            
            if(count == 1)
                return true;
            
        }
        return false;
    }
	
}
