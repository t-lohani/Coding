/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * */

package array;

public class NumberOfIslands {
	
	public static void main(String[] args) {
		char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
		System.out.println(numIslands(grid));
	}
	
    public static int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
            
        int row = grid.length;
        int col = grid[0].length;
        int answer = 0;
        
        boolean[][] visited = new boolean[row][col];
        
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (!visited[i][j] && grid[i][j]=='1') {
                    answer++;
                    doDfs(i, j, grid, row, col, visited);
                }
            }
        }
        
        return answer;
    }
    
    public static void doDfs(int rowInd, int colInd, char[][] grid, int row, int col, boolean[][] visited) {
        visited[rowInd][colInd] = true;
        
        if (colInd-1>=0 && grid[rowInd][colInd-1]=='1' && !visited[rowInd][colInd-1]) {
            doDfs(rowInd, colInd-1, grid, row, col, visited);
        }
        
        if (colInd+1<col && grid[rowInd][colInd+1]=='1' && !visited[rowInd][colInd+1]) {
            doDfs(rowInd, colInd+1, grid, row, col, visited);
        }
        
        if (rowInd-1>=0 && grid[rowInd-1][colInd]=='1' && !visited[rowInd-1][colInd]) {
            doDfs(rowInd-1, colInd, grid, row, col, visited);
        }
        
        if (rowInd+1<row && grid[rowInd+1][colInd]=='1' && !visited[rowInd+1][colInd]) {
            doDfs(rowInd+1, colInd, grid, row, col, visited);
        }
    }
}