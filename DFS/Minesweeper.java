/*
 * Let's play the minesweeper game.

You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

If a mine ('M') is revealed, then the game is over - change it to 'X'.
If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.
 * */

package dfs;

public class Minesweeper {

	public static void main(String[] args) {
		char[][] board = {{'E', 'E', 'E', 'E', 'E'},
						  {'E', 'E', 'M', 'E', 'E'},
						  {'E', 'E', 'E', 'E', 'E'},
						  {'E', 'E', 'E', 'E', 'E'}};
		int[] click = {3, 0};
		
		char[][] answer = updateBoard(board, click);
		
		for (int i=0; i<answer.length; i++) {
			for (int j=0; j<answer[0].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
        	board[click[0]][click[1]] = 'X';
        } else if (board[click[0]][click[1]] == 'E') {
            int count = countMines(board, click[0], click[1]);
            if (count > 0) {
            	board[click[0]][click[1]] = (char)(48+count);
            } else {
            	board[click[0]][click[1]] = 'B';
                doDfs(board, click[0], click[1]);
            }
        }
        
        return board;
    }
    
    public static int countMines(char[][] board, int x, int y) {
    	int[] xArr = {-1,-1,1,1,-1,1,0,0};
    	int[] yArr = {-1,1,-1,1,0,0,-1,1};
        int count = 0;
        for (int i=0; i<8; i++) {
        	if (x+xArr[i]>=0 && x+xArr[i]<board.length &&
        		y+yArr[i]>=0 && y+yArr[i]<board[0].length &&
        		board[x+xArr[i]][y+yArr[i]] == 'M') {
        		count++;
        	}
        }
    
        return count;
    }
    
    public static void doDfs(char[][] board, int x, int y) {
    	int[] xArr = {-1,-1,1,1,-1,1,0,0};
    	int[] yArr = {-1,1,-1,1,0,0,-1,1};
    	
    	for (int i=0; i<8; i++) {
        	if (x+xArr[i]>=0 && x+xArr[i]<board.length &&
        		y+yArr[i]>=0 && y+yArr[i]<board[0].length &&
        		board[x+xArr[i]][y+yArr[i]] == 'E') {
        		int count = countMines(board, x+xArr[i], y+yArr[i]);
        		if (count > 0) {
                	board[x+xArr[i]][y+yArr[i]] = (char)(48+count);
                } else {
                	board[x+xArr[i]][y+yArr[i]] = 'B';
                    doDfs(board, x+xArr[i], y+yArr[i]);
                }
        	}
        }
    }
}
