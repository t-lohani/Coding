package dynamicprogramming;

public class PallindromicSubstrings {

	public static void main(String[] args) {
		String s = "aabaa";
		System.out.println(countSubstrings(s));
	}

	public static int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[][] dp = new int[len][len];
        int answer = 0;
        
        for (int i=len-1; i>=0; i--) {
            for (int j=i; j<len; j++) {
                if (arr[i] == arr[j] && ((j-i<3) || (dp[i+1][j-1] != 0))) {
                    dp[i][j] = answer+1;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
