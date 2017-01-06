/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * */

package array;

public class SetMatrixZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,0,5,6}, {2,3,4,7,8,10}, {2,0,4,9,6,0}, {5,5,5,5,5,5}, {0,6,9,5,2,7}};
		setZeroes(matrix);
		
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j]==0) {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        
        for(int i=0; i<row.length; i++) {
            if(row[i]==1) {
                for(int j=0; j<col.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i=0; i<col.length; i++) {
            if(col[i]==1) {
                for(int j=0; j<row.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

}
