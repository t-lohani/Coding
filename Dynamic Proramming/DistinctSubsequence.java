package dynamicprogramming;

public class DistinctSubsequence {

	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		
		System.out.println(numDistinct(s, t));
	}

	public static int numDistinct(String s, String t) {
        int len = t.length();
        int wid = s.length();
        int[][] dp = new int[len+1][wid+1];
        
        for (int i=0; i<len+1; i++) {
            dp[i][0] = 0;
        }
        
        for (int i=0; i<wid+1; i++) {
            dp[0][i] = 1;
        }
        
        for (int i=1; i<len+1; i++) {
            for (int j=1; j<wid+1; j++) {
                dp[i][j] = (t.charAt(i-1) == s.charAt(j-1) ? dp[i-1][j-1] : 0) + dp[i][j-1];
            }
        }
        
        return dp[len][wid];
    }
}
