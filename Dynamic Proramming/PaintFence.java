package dynamicprogramming;

public class PaintFence {

	public static void main(String[] args) {
		int n = 10;
		int k = 4;
		
		System.out.println(numWays(n, k));
	}

	public static int numWays(int n, int k) {
        if (n==0 || k==0) {
            return 0;
        }
        
        if (n==1) {
            return k;
        }
        
        int sameCol = k;
        int diffCol = k*(k-1);
        
        for (int i=2; i<n; i++) {
            int temp = sameCol;
            sameCol = diffCol;
            diffCol = (diffCol + temp) * (k-1);
        }
        
        return diffCol + sameCol;
    }
}
