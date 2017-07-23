/*
 *  Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z. 
 * */

package tree;

public class ImplementTrie {

	public static void main(String[] args) {
		 Trie trie = new Trie();
		 trie.insert("somestring");
		 System.out.println(trie.search("key"));
	}
}


class TrieNode {
    TrieNode[] children;
    boolean wordEnd;
    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word.length()==0)
            return;
            
        TrieNode point = root;
        char[] charArr = word.toCharArray();
        for(int i=0; i<charArr.length; i++) {
        	if(point.children[charArr[i]-'a']==null) {
        		TrieNode temp = new TrieNode();
            	point.children[charArr[i]-'a'] = temp;
        	}
        	point = point.children[charArr[i]-'a'];
        }
        
        point.wordEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] charArr = word.toCharArray();
        TrieNode point = root;
        for(int i=0; i<charArr.length; i++) {
        	
        	if(point.children[charArr[i]-'a']!=null) {
        		point = point.children[charArr[i]-'a'];
        		if(i==charArr.length-1 && point.wordEnd)
        			return true;
        	} else {
        		return false;
        	}
        }
        
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	
    	char[] charArr = prefix.toCharArray();
        TrieNode point = root;
        for(int i=0; i<charArr.length; i++) {
        	if(point.children[charArr[i]-'a']!=null) {
        		point = point.children[charArr[i]-'a'];
        		if(i==charArr.length-1 && point.wordEnd)
        			return true;
        	} else {
        		return false;
        	}
        }
        
        return true;
    }
}