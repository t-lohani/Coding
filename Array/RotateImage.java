/*
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

 * */

package array;

public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		rotate(matrix);
		
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void rotate(int[][] matrix) {
        if(matrix.length==0 || matrix.length==1)
            return;
            
        int temp;
        
        for(int i=0; i<matrix.length-1; i++) {
            for(int j=i+1; j<matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        int i=0, j=matrix.length-1;
        
        while(i<=j) {
            
            for(int k=0; k<matrix.length; k++) {
                temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
            }
            
            i++;
            j--;
        }
    }

}
