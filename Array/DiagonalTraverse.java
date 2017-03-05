/*
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
Explanation:

Note:
The total number of elements of the given matrix will not exceed 10,000.
 * */

package array;

public class DiagonalTraverse {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int ans[] = findDiagonalOrder(matrix);
		
		for (int i=0; i<ans.length; i++) {
			System.out.println(ans[i] + " ");
		}
	}
	
	public static int[] findDiagonalOrder(int[][] matrix) {
		int i = 0;
        int j = 0;
        int k = 0;
        int iAdd = -1;
        int jAdd = +1;
        int len = matrix.length;
        if (len == 0) {
            return new int[0];
        }
        int wid = matrix[0].length;
        int[] answer = new int[len*wid];
        
        while (true) {
            answer[k] = matrix[i][j];
            
            if (i==len-1 && j==wid-1) {
                break;
            }
            
            i = i + iAdd;
            j = j + jAdd;
            
            if (i<0 && j>wid-1) {
                i = 1;
                j = wid-1;
                iAdd = 1;
                jAdd = -1;
            } else if (i>len-1 && j<0) {
                i = len-1;
                j = 1;
                iAdd = -1;
                jAdd = 1;
            } else if (i<0) {
                i = 0;
                iAdd = 1;
                jAdd = -1;
            } else if (i>len-1) {
                i = len-1;
                j = j+2;
                iAdd = -1;
                jAdd = 1;
            } else if (j<0) {
                j = 0;
                iAdd = -1;
                jAdd = 1;
            } else if (j>wid-1) {
                i = i+2;
                j = wid-1;
                iAdd = 1;
                jAdd = -1;
            }
            
            k++;
        }
        
        return answer;
    }

}
