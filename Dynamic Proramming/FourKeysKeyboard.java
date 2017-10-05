package dynamicprogramming;

public class FourKeysKeyboard {

	public static void main(String[] args) {
		System.out.println(maxA(15));
	}

	public static int maxA(int N) {
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j <= i - 3; j++)
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
        }
        return dp[N];
    }
}
