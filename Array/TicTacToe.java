/*
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * */

package array;

public class TicTacToe {
    
    public static int[] rows, cols;
    public static int diag1, diag2;

    public static void main(String[] args) {
    	TicTacToe ttt = new TicTacToe(3);
    	System.out.println(move(0, 0, 1));
    	System.out.println(move(1, 1, 1));
    	System.out.println(move(2, 2, 2));
    	System.out.println(move(0, 2, 1));
    	System.out.println(move(0, 1, 2));
    	System.out.println(move(2, 0, 1));
    	
    }
    
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag1 = 0;
        diag2 = 0;
    }
    
    public static int move(int row, int col, int player) {
        if (player == 1) {
            if (rows[row] < 0) {
                rows[row] = rows.length+1;
            } else {
                rows[row]++;
            }
            if (rows[row] == rows.length) {
                return 1;
            } 
            
            if (cols[col] < 0) {
                cols[col] = rows.length+1;
            } else {
                cols[col]++;
            }
            if (cols[col] == cols.length) {
                return 1;
            }
            
            if (row == col) {
                if (diag1 < 0) {
                    diag1 = rows.length+1;
                } else {
                    diag1++;
                }
                if (diag1 == rows.length) {
                    return 1;
                }
            }
            
            if (row + col == rows.length-1) {
                if (diag2 < 0) {
                    diag2 = rows.length+1;
                } else {
                    diag2++;
                }
                if (diag2 == rows.length) {
                    return 1;
                } 
            }
            
        } else {
            if (rows[row] > 0) {
                rows[row] = -rows.length-1;
            } else {
                rows[row]--;
            }
            if (rows[row] == -rows.length) {
                return 2;
            } 
            
            if (cols[col] > 0) {
                cols[col] = -rows.length-1;
            } else {
                cols[col]--;
            }
            if (cols[col] == -cols.length) {
                return 2;
            }
            
            if (row == col) {
                if (diag1 > 0) {
                    diag1 = -rows.length-1;
                } else {
                    diag1--;
                }
                if (diag1 == -rows.length) {
                    return 2;
                }
            }
            
            if (row + col == rows.length-1) {
                if (diag2 > 0) {
                    diag2 = -rows.length-1;
                } else {
                    diag2--;
                }
                if (diag2 == -rows.length) {
                    return 2;
                } 
            }
        }
        
        return 0;
    }
}