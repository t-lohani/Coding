package dynamicprogramming;

public class UniquePaths2 {

	public static void main(String[] args) {
		int[][] obs = {{0,0},{0,0}};
		System.out.println(uniquePathsWithObstacles(obs));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len = obstacleGrid.length;
        int wid = obstacleGrid[0].length;
        int[][] dp = new int[len][wid];
        
        if (obstacleGrid[0][0] == 0)
            dp[0][0] = 1;
        
        for (int i=1; i<wid; i++) {
            dp[0][i] = (obstacleGrid[0][i] == 1) ? 0 : dp[0][i-1];
        }
        
        for (int j=1; j<len; j++) {
            dp[j][0] = (obstacleGrid[j][0] == 1) ? 0 : dp[j-1][0];
        }
        
        for (int i=1; i<len; i++) {
            for (int j=1; j<wid; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[len-1][wid-1];
    }
}
