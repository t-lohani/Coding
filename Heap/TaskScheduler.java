package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));
	}

	public static int leastInterval(char[] tasks, int n) {
	    Map<Character, Integer> map = new HashMap<>();
	    for (int i = 0; i < tasks.length; i++) {
	        map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
	    }
	    DecsendingComparator dc = new DecsendingComparator();
	    PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(dc);

	    q.addAll(map.entrySet());

	    int count = 0;
	    while (!q.isEmpty()) {
	        int k = n + 1;
	        List<Map.Entry<Character, Integer>> tempList = new ArrayList<>();
	        while (k > 0 && !q.isEmpty()) {
	            Map.Entry<Character, Integer> top = q.poll();
	            top.setValue(top.getValue() - 1);
	            tempList.add(top);
	            k--;
	            count++;
	        }

	        for (Map.Entry<Character, Integer> e : tempList) {
	            if (e.getValue() > 0) q.add(e); 
	        }

	        if (q.isEmpty()) break;
	        count = count + k;
	    }
	    return count;
	}
}

class DecsendingComparator implements Comparator<Map.Entry<Character, Integer>> {

	public int compare(Entry<Character, Integer> a, Entry<Character, Integer> b) {
		if (b.getValue() == a.getValue()) {
			return a.getKey()-b.getKey();
		} else {
			return b.getValue() - a.getValue();
		}
	}

}