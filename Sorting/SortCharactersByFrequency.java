/*
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * */

package sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
	}

	public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        char[] chArr = s.toCharArray();
        
        for (int i=0; i<chArr.length; i++) {
            map.put(chArr[i], map.getOrDefault(chArr[i], 0)+1);
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Node temp = new Node(entry.getKey(), entry.getValue());
            pQ.add(temp);
        }
        
        StringBuilder str = new StringBuilder();
        
        while(!pQ.isEmpty()) {
            Node temp = pQ.remove();
            for (int i=0; i<temp.freq; i++) {
                str.append(temp.key);
            }
        }
        
        return str.toString();
    }
}


class Node implements Comparable<Node>{
    char key;
    int freq;
    
    public Node(char key, int freq) {
    	this.key = key;
    	this.freq = freq;
    }
    
    public int compareTo(Node node) {
        return node.freq - this.freq;
    }
}
