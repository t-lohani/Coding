package dynamicprogramming;

public class WildcardMatching {

	public static void main(String[] args) {
		String s = "aa";
		String p = "a*";
		System.out.println(isMatch(s, p));
	}
	
	public static boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        
        int index = 0;
        boolean isFirst = true;
        
        for (int i=0; i<pArr.length; i++) {
            if (pArr[i] == '*') {
                if (isFirst) {
                    pArr[index] = pArr[i];
                    index++;
                    isFirst = false;
                }
            } else {
                pArr[index] = pArr[i];
                index++;
                isFirst = true;
            }
        }
                
        boolean[][] dp = new boolean [sArr.length+1][index+1];
        dp[0][0] = true;
        
        if (pArr.length > 0 && pArr[0] == '*') {
            dp[0][1] = true;
        }
        
        for (int i=0; i<sArr.length; i++) {
            for (int j=0; j<index; j++) {
                if (pArr[j] == sArr[i] || pArr[j] == '?') {
                    dp[i+1][j+1] = dp[i][j];
                } else if (pArr[j] == '*') {
                    dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1];
                }
            }
        }
        
        return dp[sArr.length][index];
    }

}
