package segmenttree;

public class RangeSumQuery2DMutable {

	public static void main(String[] args) {
		int[][] matrix = {{3,0,1,4,2},
						  {5,6,3,2,1},
						  {1,2,0,1,5},
						  {4,1,0,1,7},
						  {1,0,3,0,5}}; 
		NumMatrix nm = new NumMatrix(matrix);
		
		System.out.println(nm.sumRegion(2, 1, 4, 3));
		nm.update(3, 2, 2);
		System.out.println(nm.sumRegion(2, 1, 4, 3));
	}

}

class NumMatrix {
    int len, wid;
    int[][] tree;
    int[][] nums;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        len = matrix.length;
        wid = matrix[0].length;
        
        tree = new int[len+1][wid+1];
        nums = new int[len][wid];
        
        for (int i=0; i<len; i++) {
            for (int j=0; j<wid; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if (len == 0 || wid == 0)
            return;
        
        int diff = val - nums[row][col];
        nums[row][col] = val;
        
        for (int i=row+1; i<=len; i += i & (-i)) {
            for (int j=col+1; j<=wid; j += j & (-j)) {
                tree[i][j] += diff;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (len == 0 || wid == 0)
            return 0;
        
        return sum(row2+1, col2+1) + sum (row1, col1) - sum(row2+1, col1) - sum(row1, col2+1); 
    }
    
    public int sum(int row, int col) {
        int sum = 0;
        
        for (int i=row; i>0; i -= i & (-i)) {
            for (int j=col; j>0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        
        return sum;
    }
}