package divideandconquer;

public class SearchA2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1}, {3}};
		int target = 1;
		
		System.out.println(searchMatrix(matrix, target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0)
            return false;
        
        int col = matrix[0].length;

        int start = 0;
        int end = (row*col) - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(matrix[mid/col][mid%col] == target) {
                return true;
            } else if(matrix[mid/col][mid%col] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return false;
    }
}
