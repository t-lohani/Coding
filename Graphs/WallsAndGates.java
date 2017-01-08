package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

	public static void main(String[] args) {
		int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
		wallsAndGates(rooms);
		
		for (int i=0; i<rooms.length; i++) {
			for (int j=0; j<rooms[0].length; j++) {
				System.out.print(rooms[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void wallsAndGates(int[][] rooms) {
        
		int row = rooms.length;
        if (row == 0)
            return;
        int col = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        
        doBfs(rooms, queue);
    }
    
    public static void doBfs(int[][] rooms, Queue<int[]> queue) {
        
        while (!queue.isEmpty()) {
            int[] node = queue.remove();
            int row = node[0], col = node[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
}