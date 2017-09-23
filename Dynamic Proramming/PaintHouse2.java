package dynamicprogramming;

public class PaintHouse2 {

	public static void main(String[] args) {
		int[][] costs = {{10,15,12,14,18,5},{5,12,18,13,15,8},{4,7,4,2,10,18},{20,9,9,19,20,5},{10,15,10,15,16,20},{9,6,11,10,12,11},{7,10,6,12,20,8},{3,4,4,18,10,2}};
		System.out.println(minCostII(costs));
	}

	public static int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        
        int n = costs.length, k = costs[0].length;

        int min1 = -1, min2 = -1;

        for (int i = 0; i < n; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1; min2 = -1;

            for (int j = 0; j < k; j++) {
                if (j != last1) {
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }

                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1; min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }

        return costs[n - 1][min1];
    }
}
