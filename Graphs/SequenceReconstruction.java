package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SequenceReconstruction {

	public static void main(String[] args) {
		int[] org = {1,2,3};
		List<List<Integer>> seqs = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		temp.add(2);
		seqs.add(temp);
		temp = new ArrayList<>();
		temp.add(1);
		temp.add(3);
		seqs.add(temp);
		temp = new ArrayList<>();
		temp.add(2);
		temp.add(3);
		seqs.add(temp);
		
		System.out.println(sequenceReconstruction(org, seqs));
	}
	
	public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        
        for (List<Integer> elem : seqs) {
            if (elem.size() == 1) {
                map.putIfAbsent(elem.get(0), new HashSet<>());
                degree.putIfAbsent(elem.get(0), 0);
            } else {
                for(int i = 0; i < elem.size() - 1; i++) {
                    map.putIfAbsent(elem.get(i), new HashSet<>());
                    degree.putIfAbsent(elem.get(i), 0);

                    map.putIfAbsent(elem.get(i+1), new HashSet<>());
                    degree.putIfAbsent(elem.get(i+1), 0);

                    if(map.get(elem.get(i)).add(elem.get(i+1))) {
                        degree.put(elem.get(i+1), degree.get(elem.get(i+1)) + 1);
                    }
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: degree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        int index = 0;
        while(!queue.isEmpty()) {
            if(queue.size() > 1) {
                return false;
            }
            int curr = queue.remove();
            if(index == org.length || curr != org[index++]) {
                return false;
            }
            for(int next: map.get(curr)) {
                degree.put(next, degree.get(next) - 1);
                if(degree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return index == org.length && index == map.size();
    }

}
