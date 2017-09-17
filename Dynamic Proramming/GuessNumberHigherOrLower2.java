package dynamicprogramming;

public class GuessNumberHigherOrLower2 {

	public static void main(String[] args) {
		System.out.println(getMoneyAmount(15));
	}

	public static int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return recurse(dp, 1, n);
    }
    
    public static int recurse(int[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        
        int ret = Integer.MAX_VALUE;
        for (int i=start; i<=end; i++) {
            int temp = i + Math.max(recurse(dp, start, i-1), recurse(dp, i+1, end));
            ret = Math.min(ret, temp);
        }
        
        dp[start][end] = ret;
        return dp[start][end];
    }
}
