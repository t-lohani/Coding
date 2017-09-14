package dynamicprogramming;

public class PaintHouse {

	public static void main(String[] args) {
		int[][] costs = {{2,3,1},{4,1,5},{3,2,5},{4,4,4},{6,1,2},{1,4,5}};
		System.out.println(minCost(costs));
	}
	
	public static int minCost(int[][] costs) {
        int len = costs.length;
        if (len == 0)
            return 0;
        
        for (int i=1; i<len; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        
        return Math.min(costs[len-1][0], Math.min(costs[len-1][1], costs[len-1][2]));
    }
}
