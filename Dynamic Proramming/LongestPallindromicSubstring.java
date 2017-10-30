package dynamicprogramming;

public class LongestPallindromicSubstring {

	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        String answer = null;
        
        for (int i=len-1; i>=0; i--) {
            for (int j=i; j<len; j++) {
                dp[i][j] = arr[i] == arr[j] && (j-i<3 || dp[i+1][j-1]);
                
                if (dp[i][j] && (answer == null || j-i+1 > answer.length())) {
                    answer = s.substring(i, j+1);
                }
            }
        }
        
        return answer;
    }
}
