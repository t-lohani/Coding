/*
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * */

package graphs;
public class SurroundedRegions {

	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
		solve(board);
		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void solve(char[][] board) {
        if (board.length == 0)
            return;
            
        int row = board.length;
        int col = board[0].length;
        
        for (int i=0; i<col; i++) {
            if (board[0][i] == 'O') {
                doDfs(board, 0, i);
            }
            
            if (board[row-1][i] == 'O') {
                doDfs(board, row-1, i);
            }
        }
        
        for (int i=0; i<row; i++) {
            if (board[i][0] == 'O') {
                doDfs(board, i, 0);
            }
            
            if (board[i][col-1] == 'O') {
                doDfs(board, i, col-1);
            }
        }
        
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public static void doDfs(char[][] board, int i, int j) {
        // System.out.println("x : " + x + " y : " + y);
        if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
    		return;
    	if (board[i][j] == 'O')
    		board[i][j] = '#';
    	if (i > 1 && board[i-1][j] == 'O')
    		doDfs(board, i-1, j);
    	if (i < board.length - 2 && board[i+1][j] == 'O')
    		doDfs(board, i+1, j);
    	if (j > 1 && board[i][j-1] == 'O')
    		doDfs(board, i, j-1);
    	if (j < board[i].length - 2 && board[i][j+1] == 'O' )
    		doDfs(board, i, j+1);
    }

}
