package trie;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWord {
	Trie root;
    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie itr = root;
        char[] arr = word.toCharArray();
        for (int i=0; i<arr.length; i++) {
            itr.map.putIfAbsent(arr[i], new Trie());
            itr = itr.map.get(arr[i]);
        }
        itr.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return backtrack(word.toCharArray(), 0, root);
    }
    
    public boolean backtrack(char[] arr, int ind, Trie itr) {
        if (ind == arr.length) {
            return itr.isWord;
        }
        
        if (arr[ind] == '.') {
            for (Map.Entry<Character, Trie> entry : itr.map.entrySet()) {
                if (backtrack(arr, ind+1, entry.getValue())) {
                    return true;
                }
            }
        } else {
            return itr.map.get(arr[ind]) != null && backtrack(arr, ind+1, itr.map.get(arr[ind]));
        }
        
        return false;
    }
}

class Trie {
    Map<Character, Trie> map = new HashMap<>();
    boolean isWord = false;
}