/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.

How many possible unique paths are there?
 * */

package dynamicprogramming;

public class UniquePaths {

	public static void main(String[] args) {
		int m = 5;
		int n = 15;
		
		System.out.println(uniquePaths(m, n));
	}

	public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(i==0 || j==0) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }
            }
        } 
        
        return matrix[m-1][n-1];
    }
}
