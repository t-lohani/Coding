package dynamicprogramming;

public class OnesAndZeroes {

	public static void main(String[] args) {
		String[] strs = {"10","0001","111001","1","0"};
		int m = 5;
		int n = 3;
		
		int answer = findMaxForm(strs, m, n);
		
		System.out.println(answer);
	}
	
	public static int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        
        for (int i=0; i<len; i++) {
            int[] arr = count(strs[i]);
            for (int j=m; j>=arr[0]; j--) {
                for (int k=n; k>=arr[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-arr[0]][k-arr[1]] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static int[] count(String str) {
        int[] res = new int[2];
        for (int i=0; i<str.length(); i++)
            res[str.charAt(i) - '0']++;
        return res;
    }
}