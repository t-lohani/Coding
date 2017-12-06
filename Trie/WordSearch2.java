package trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

	public static void main(String[] args) {
		char[][] board = {
				  {'o','a','a','n'},
				  {'e','t','a','e'},
				  {'i','h','k','r'},
				  {'i','f','l','v'}
				};
		String[] words = {"oath","pea","eat","rain"};
		
		List<String> ans = findWords(board, words);
		
		for (int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}

	public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        List<String> answer = new ArrayList<>();
        
        for (int i=0; i<words.length; i++) {
            insert(words[i], root);
        }
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                doDfs(board, i, j, root, answer);
            }
        }
        
        return answer;
    }
    
    public static void doDfs (char[][] board, int x, int y, TrieNode node, List<String> ans) {
        char ch = board[x][y];
        if (ch == '#' || node.child[ch-'a'] == null)
            return;
        
        node = node.child[ch-'a'];
        
        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }
        
        board[x][y] = '#';
        int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        
        for (int i=0; i<4; i++) {
            int newX = x+dir[i][0];
            int newY = y+dir[i][1];
            
            if (newX >= 0 && newY >=0 && newX < board.length && newY < board[0].length) {
                doDfs(board, newX, newY, node, ans);
            }
        }
        
        board[x][y] = ch;
    }
    
    public static void insert (String word, TrieNode root) {
        char[] arr = word.toCharArray();
        
        for (int i=0; i<arr.length; i++) {
            if (root.child[arr[i]-'a'] == null) {
                root.child[arr[i]-'a'] = new TrieNode();
            }
            root = root.child[arr[i]-'a'];
        }
        root.word = word;
    }
}


class TrieNode {
    TrieNode[] child = new TrieNode[26];
    String word;
}

class Trie {
    TrieNode root;
    
    public Trie () {
        root = new TrieNode();
    }
    
}