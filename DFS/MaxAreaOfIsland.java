package dfs;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,1,1,0,1,0,0,0,0,0,0,0,0},
				 {0,1,0,0,1,1,0,0,1,0,1,0,0},
				 {0,1,0,0,1,1,0,0,1,1,1,0,0},
				 {0,0,0,0,0,0,0,0,0,0,1,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		
		System.out.println(maxAreaOfIsland(grid));
	}

	static int answer = 0;
	static int loc = 0;
	static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public static int maxAreaOfIsland(int[][] grid) {
        int len = grid.length;
        if (len == 0)
            return 0;
        int wid = grid[0].length;
        
        boolean[][] visited = new boolean[len][wid];
        
        for (int i=0; i<len; i++) {
            for (int j=0; j<wid; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    loc = 0;
                    answer = Math.max(answer, doDfs(i, j, grid, visited, len, wid));
                }
            }
        }
        
        return answer;
    }
    
    public static int doDfs(int x, int y, int[][] grid, boolean[][] vis, int len, int wid) {
        loc++;
        vis[x][y] = true;
        
        for (int i=0; i<4; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            
            if (newX >= 0 && newX < len && newY >= 0 && newY < wid && !vis[newX][newY] && grid[newX][newY] == 1) {
                doDfs(newX, newY, grid, vis, len, wid);
            }
        }
        
        return loc;
    }
}
