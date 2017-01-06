/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * */

package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		List<Integer> answer = spiralOrder(matrix);
		
		for (int i=0; i<answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
        
		List<Integer> answer = new ArrayList<>();
        if (matrix.length == 0) {
            return answer;
        }
        
        int left = 0,top = 0;
        int right = matrix[0].length-1, down = matrix.length-1;
        
        while (left <= right && top <= down) {
            for (int j = left; j <= right; j ++) {
                answer.add(matrix[top][j]);
            }
            top++;

            if (top > down)
                break;
            for (int i = top; i <= down; i ++) {
                answer.add(matrix[i][right]);
            }
            right--;

            if (left > right)
                break;
            for (int j = right; j >= left; j --) {
                answer.add(matrix[down][j]);
            }
            down--;

            if (top > down)
                break;
            for (int i = down; i >= top; i --) {
                answer.add(matrix[i][left]);
            }
            left++;
        }
        
        return answer;
    }
}
