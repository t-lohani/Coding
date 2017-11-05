package backtracking;

public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
		solve(board);
		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public static boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;

                            if(solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false;
            if(board[row][i] != '.' && board[row][i] == c) return false;
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] != '.' && 
                    board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }
}
