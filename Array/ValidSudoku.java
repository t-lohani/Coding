/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * */

package array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
						{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
						{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
						{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
						{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
						{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
						{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
						{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
						{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		
		System.out.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
        Set<Character> unique;
        
        for(int i=0; i<board.length; i++) {
            unique = new HashSet<Character>();
            for(int j=0; j<board.length; j++) {
                if(board[i][j]!='.') {
                    if(!unique.add(board[i][j]))
                        return false;               
                }
            }
        }
        
        for(int i=0; i<board.length; i++) {
            unique = new HashSet<Character>();
            for(int j=0; j<board.length; j++) {
                if(board[j][i]!='.') {
                    if(!unique.add(board[j][i]))
                        return false;            
                }
            }
        }
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                unique = new HashSet<Character>();
                for(int k=i*3; k<(i+1)*3; k++) {
                    for(int l=j*3; l<(j+1)*3; l++) {
                        if(board[k][l]!='.') {
                            if(!unique.add(board[k][l]))
                                return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
