package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0,1},{0,2},{0,3},{3,4}};
		
		List<Integer> answer = findMinHeightTrees(n, edges);
		
		for (int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}

	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if (n==1) {
            leaves.add(0);
            return leaves;
        }
        
        List<Set<Integer>> adj = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            adj.add(new HashSet<Integer>());
        }
        for (int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        for (int i=0; i<n; i++) {
            if (adj.get(i).size() == 1)
                leaves.add(i);
        }
        
        while (n>2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            
            for (int i=0; i<leaves.size(); i++) {
                int j = adj.get(leaves.get(i)).iterator().next();
                adj.get(j).remove(leaves.get(i));
                if (adj.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            
            leaves = newLeaves;
        }
        
        return leaves;
    }
}
