package unionfind;

public class RedundantConnection {

	public static void main(String[] args) {
		int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
		int[] edge = findRedundantConnection(edges);
		
		System.out.println(edge[0] + "," + edge[1]);
	}

	public static int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length;
        int[] parent = new int[nodes+1];
        
        for (int i=1; i<parent.length; i++) {
            parent[i] = i;
        }
        
        for (int i=0; i<edges.length; i++) {
            int x = findParent(edges[i][0], parent);
            int y = findParent(edges[i][1], parent);
            
            if (x == y)
                return edges[i];
            
            else {
                union(edges[i][0], edges[i][1], parent);
            }
        }
        
        return null;
    }
    
    public static int findParent(int ind, int[] parent) {
        while (parent[ind] != ind) {
            ind = parent[ind];
        }
        
        return parent[ind];
    }
    
    public static void union(int a, int b, int[] parent) {
        while(parent[a] != a) {
            a = parent[a];
        }
        
        while(parent[b] != b) {
            b = parent[b];
        }
        
        parent[a] = b;
    }
}
