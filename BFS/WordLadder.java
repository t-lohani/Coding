package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
        Set<String> qStart = new HashSet<>();
        Set<String> qEnd = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        qStart.add(beginWord);
        if (dict.contains(endWord))
        	qEnd.add(endWord);
        
        for (int len = 2; !qStart.isEmpty(); len++) {
            Set<String> newQueue = new HashSet<>();
            for (String w : qStart) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue;
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (qEnd.contains(nb)) return len;
                        if (dict.contains(nb) && visited.add(nb)) newQueue.add(nb);
                    }
                }
            }
            qStart = (newQueue.size() < qEnd.size()) ? newQueue : qEnd;
            qEnd = (qStart == newQueue) ? qEnd : newQueue;
        }
        return 0;
    }
}
