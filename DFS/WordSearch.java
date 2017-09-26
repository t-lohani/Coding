package dfs;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {{'a', 'b'}, {'c', 'd'}};
		String word = "cdba";
		
		System.out.println(exist(board, word));
	}

	public static boolean found = false;
	public static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
    public static boolean exist(char[][] board, String word) {
        if(word.length()==0) return false;
        doDfs(board, word, 0, -1, -1);
        return found;
    }
    
    private static void doDfs(char[][] board, String word, int pos, int x, int y){
        if(pos == word.length() || found){
            found = true;
            return;
        }
        
        if(x==-1 && y==-1){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j] == word.charAt(pos)){
                        char ch = board[i][j];
                        board[i][j]='1';
                        doDfs(board, word, pos+1, i, j);   
                        board[i][j] = ch;

                    }
                }
            }
        } else {
            char cmp = word.charAt(pos);
            for (int i=0; i<4; i++) {
            	int newX = x + dirs[i][0];
            	int newY = y + dirs[i][1];
            	
            	if (newX>=0 && newY>=0 && newX < board.length
            			&& newY<board[0].length
            			&& board[newX][newY]==cmp) {
            		char c = board[newX][newY];
                    board[newX][newY]='1';
                    doDfs(board, word, pos+1, newX, newY);
                    board[newX][newY]=c;
            	}
            }
        }
    }
}