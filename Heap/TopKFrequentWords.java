package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	
	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		
		List<String> ans = topKFrequent(words, k);
		for (int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
	
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<HeapNode> queue = new PriorityQueue<>();
        
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(new HeapNode(entry.getKey(), entry.getValue()));
        }
        
        List<String> answer = new ArrayList<>();
        for (int i=0; i<k; i++) {
            answer.add(queue.remove().str);
        }
        
        return answer;
    }
}

class HeapNode implements Comparable<HeapNode> {
    String str;
    int freq;
    
    public HeapNode(String s, int f) {
        str = s;
        freq = f;
    }
    
    public int compareTo(HeapNode node) {
        if (node.freq == this.freq) {
            return this.str.compareTo(node.str);
        } else {
            return node.freq - this.freq;
        }
    }
}