package array;

public class ImageSmoother {
	public static void main(String args[]) {
		int[][] M = {{1,1,1}, {1,0,1}, {1,1,1}};
		int[][] answer = imageSmoother(M);
		
		for (int i=0; i<answer.length; i++) {
			for (int j=0; j<answer[0].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {1,-1}, {-1,1}, {1,1}};
    public static int[][] imageSmoother(int[][] M) {
        int len = M.length;
        if (len == 0) {
            return M;
        }
        int wid = M[0].length;
        int[][] answer = new int[len][wid];
        
        for (int i=0; i<len; i++) {
            for (int j=0; j<wid; j++) {
                smoother(i, j, M, answer);
            }
        }
        
        return answer;
    }
    
    public static void smoother(int x, int y, int[][] mat, int[][] ans) {

        int sum = mat[x][y];
        int neighbour = 1;
        
        for (int i=0; i<8; i++) {
            int newX = x+dir[i][0];
            int newY = y+dir[i][1];
            if (newX >=0 && newX < mat.length && newY >= 0 && newY < mat[0].length) {
                sum += mat[newX][newY];
                neighbour++;
            }
        }
        
        ans[x][y] = sum/neighbour;
    }
}
