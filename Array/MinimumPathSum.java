/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * */

package array;

public class MinimumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = {{1,2,3,4,5}, {6,7,8,9,9}, {8,7,6,5,4}, {3,2,1,1,2}, {3,4,5,6,7}};
		System.out.println(minPathSum(grid));
	}
	
	public static int minPathSum(int[][] grid) {
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(i==0 || j==0) {
                    if(i==0 && j==0)
                        grid[i][j] = grid[i][j];
                    else if(i==0)
                        grid[i][j] = grid[i][j]+grid[i][j-1];
                    else if(j==0)
                        grid[i][j] = grid[i][j]+grid[i-1][j];
                }
                else
                    grid[i][j] = grid[i][j-1]<grid[i-1][j]?(grid[i][j]+grid[i][j-1]):(grid[i][j]+grid[i-1][j]);
            }
        }
        
        return grid[grid.length-1][grid[0].length-1];
    }

}
