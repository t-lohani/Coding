package array;

public class SearchA2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{2, 5}, {2, 8}, {7, 9}, {7, 11}, {9,11}};
		int target = 7;
		System.out.println(searchMatrix(matrix, target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
        int rInd = 0;
        int cInd = 0;
        int row = matrix.length;
        if (row == 0)
            return false;
        int col = matrix[0].length;
        
        if (target < matrix[rInd][cInd])
            return false;
        
        while (rInd < row && cInd < col && matrix[rInd][cInd] <= target) {
            if (matrix[rInd][cInd] == target)
                return true;
                
            rInd++;
            cInd++;
            
            if (cInd == col && rInd!=row) {
                cInd = 0;
            }
        }
        
        if (rInd == row && cInd == col) {
            return false;
        } else if (rInd == row) {
            for (int i=cInd-1; i<col; i++) {
                if (matrix[rInd-1][i] == target)
                    return true;
                else if (matrix[rInd-1][i] == target)
                    return false;
            }
        } else {
            for (int i=rInd-1; i<rInd+1; i++) {
                for (int j=0; j<col; j++) {
                    if (matrix[i][j] == target)
                        return true;
                }
            }
        }
    
        return false;
    }
}
