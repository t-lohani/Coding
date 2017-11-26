package dfs;

public class FloodFill {

	public static void main(String[] args) {
		int[][] image = {{1,1,1}, {1,1,1}, {1,1,0}};
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		
		floodFill(image, sr, sc, newColor);
		
		for (int i=0; i<image.length; i++) {
			for (int j=0; j<image[0].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int len = image.length;
        if (len == 0)
            return image;
        int wid = image[0].length;
        int col = image[sr][sc];
        
        if (col == newColor)
            return image;
        
        boolean[][] visited = new boolean[len][wid];
        
        doDfs(image, len, wid, sr, sc, visited, newColor, col);
        return image;
    }
    
    public static void doDfs(int[][] image, int len, int wid, int x, int y, boolean[][] vis, int newCol, int col) {
        vis[x][y] = true;
        image[x][y] = newCol;
        
        for (int i=0; i<dirs.length; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX < len && newX >=0 && newY < wid && newY >= 0 && !vis[newX][newY] && image[newX][newY] == col) {
                doDfs(image, len, wid, newX, newY, vis, newCol, col);
            }
        }
    }
}
