/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 * */

package dynamicprogramming;

public class MaximalSquare {

	public static void main(String[] args) {
		char[][] matrix = {{'1', '0', '1', '0', '0'},
						   {'1', '0', '1', '1', '1'},
						   {'1', '1', '1', '1', '1'},
						   {'1', '0', '0', '1', '0'}};
		System.out.println(maximalSquare(matrix));
	}

	public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        
        int len = matrix.length;
        int wid = matrix[0].length;
        int max = 0;
        
        int[][] mat = new int[len+1][wid+1];
        
        for (int i = 1 ; i <= len; i++) {
            for (int j = 1; j <= wid; j++) {
                if(matrix[i-1][j-1] == '1') {
                    mat[i][j] = Math.min(Math.min(mat[i][j-1] , mat[i-1][j-1]), mat[i-1][j]) + 1;
                    if (mat[i][j] > max) {
                        max = mat[i][j];
                    }
                }
            }
        }
        return max*max;
    }
}
