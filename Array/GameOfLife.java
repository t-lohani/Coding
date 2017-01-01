/*
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.
 * */

package array;

public class GameOfLife {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] board = {{1,1,0,1,0}, {1,1,1,0,0}, {0,0,1,0,0}, {1,1,0,0,1}, {1,1,1,0,1}};
		gameOfLife(board);
		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void gameOfLife(int[][] board) {
        
        if(board.length==0)
            return;
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = checkNextStep(board, i, j);
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]==3)
                    board[i][j] = 1;
                else if(board[i][j]==2)
                    board[i][j] = 0;
            }
        }
    }
    
    public static int checkNextStep(int[][] board, int row, int col) {
        int countLive = 0;
        
        if(row-1>=0 && col-1>=0 && (board[row-1][col-1]==1 || board[row-1][col-1]==2)) countLive++;
        if(row-1>=0 && (board[row-1][col]==1 || board[row-1][col]==2)) countLive++;
        if(row-1>=0 && col+1<board[0].length && (board[row-1][col+1]==1 || board[row-1][col+1]==2)) countLive++;
        if(col-1>=0 && (board[row][col-1]==1 || board[row][col-1]==2)) countLive++;
        if(col+1<board[0].length && (board[row][col+1]==1 || board[row][col+1]==2)) countLive++;
        if(row+1<board.length && col-1>=0 && (board[row+1][col-1]==1 || board[row+1][col-1]==2)) countLive++;
        if(row+1<board.length && (board[row+1][col]==1 || board[row+1][col]==2)) countLive++;
        if(row+1<board.length && col+1<board[0].length && (board[row+1][col+1]==1 || board[row+1][col+1]==2)) countLive++;
        
        if(board[row][col]==0) {
            if(countLive==3)
                return 3;
            else
                return 0;
        }
        else {
            if(countLive!=2 && countLive!=3)
                return 2;
            else
                return 1;
        }
    }

}
