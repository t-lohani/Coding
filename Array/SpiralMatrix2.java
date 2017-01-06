/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * */

package array;

public class SpiralMatrix2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int square = 4;
		int[][] answer = generateMatrix(square);
		
		for (int i=0; i<square; i++) {
			for (int j=0; j<square; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int left = 0,top = 0;
        int right = n -1,down = n - 1;
        int count = 1;
        while (left <= right) {
            for (int j = left; j <= right; j ++) {
                ret[top][j] = count++;
            }
            top ++;
            for (int i = top; i <= down; i ++) {
                ret[i][right] = count ++;
            }
            right --;
            for (int j = right; j >= left; j --) {
                ret[down][j] = count ++;
            }
            down --;
            for (int i = down; i >= top; i --) {
                ret[i][left] = count ++;
            }
            left ++;
        }
        return ret;
    }

}
