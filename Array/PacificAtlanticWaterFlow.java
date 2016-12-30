/*
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * */

package array;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
		pacificAtlantic(matrix);
		
	}
	
    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> answer = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] aVisited = new boolean[m][n];
        boolean[][] pVisited = new boolean[m][n];
        
        doDfsPacific(0, 0, matrix, pVisited);
        doDfsAtlantic(m-1, n-1, matrix, aVisited);
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                	int[] temp = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    System.out.println(i + " " + j);
                    answer.add(temp);
                }
            }
        }
        
        return answer;
    }
    
    public static void doDfsPacific(int row, int col, int[][] mat, boolean[][] visited) {
        visited[row][col] = true;
        
        if (col - 1 >= 0 && !visited[row][col-1]) {
            if ((row == 0) || ((mat[row][col] - mat[row][col-1]) >= 0))
                doDfsPacific(row, col-1, mat, visited);
        }
        
        if (col + 1 < mat[0].length && !visited[row][col+1]) {
            if ((row == 0) || (mat[row][col] - mat[row][col+1]) <= 0)
                doDfsPacific(row, col+1, mat, visited);
        }
        
        if (row - 1 >= 0 && !visited[row-1][col]) {
            if ((col == 0) || ((mat[row][col] - mat[row-1][col]) >= 0))
                doDfsPacific(row-1, col, mat, visited);
        }
        
        if (row + 1 < mat.length && !visited[row+1][col]) {
            if ((col == 0) || (mat[row][col] - mat[row+1][col]) <= 0)
                doDfsPacific(row+1, col, mat, visited);
        }
    }
    
    public static void doDfsAtlantic(int row, int col, int mat[][], boolean[][] visited) {
        visited[row][col] = true;
        if (col - 1 >= 0 && !visited[row][col-1]) {
            if ((row == mat.length-1) || (mat[row][col] - mat[row][col-1]) <= 0)
            	doDfsAtlantic(row, col-1, mat, visited);
        }
        
        if (col + 1 < mat[0].length && !visited[row][col+1]) {
            if ((row == mat.length-1) || (mat[row][col] - mat[row][col+1]) >= 0)
            	doDfsAtlantic(row, col+1, mat, visited);
        }
        
        if (row - 1 >= 0 && !visited[row-1][col]) {
            if ((col == mat[0].length-1) || (mat[row][col] - mat[row-1][col]) <= 0)
            	doDfsAtlantic(row-1, col, mat, visited);
        }
        
        if (row + 1 < mat.length && !visited[row+1][col]) {
            if ((col == mat[0].length-1) || (mat[row][col] - mat[row+1][col]) >= 0)
            	doDfsAtlantic(row+1, col, mat, visited);
        }
    }
}