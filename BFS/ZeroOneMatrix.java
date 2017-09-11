package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{0,1,1}, {1,1,1}, {1,1,1}};
		int[][] answer = updateMatrix(matrix);
		
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] updateMatrix(int[][] matrix) {
        Queue<Node> queue = new LinkedList<>();
        int len = matrix.length;
        if (len == 0) {
            return matrix;
        }
        int wid = matrix[0].length;
        boolean[][] visited = new boolean[len][wid];
        
        for (int i=0; i<len; i++) {
            for (int j=0; j<wid; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        queue.add(null);
        int level = 1;
        int[][] dir = {{0,1}, {0,-1}, {-1, 0}, {1, 0}};
        int[][] answer = new int[len][wid];
        while (!queue.isEmpty()) {
            Node popped = queue.remove();
            if (popped == null) {
                if (!queue.isEmpty()) {
                    level++;
                    queue.add(null);
                }
            } else {
                for (int i=0; i<4; i++) {
                    int newX = popped.x + dir[i][0];
                    int newY = popped.y + dir[i][1];
                    if (newX >= 0 && newY >= 0 && newX < len && newY < wid && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.add(new Node(newX, newY, level));
                        answer[newX][newY] = level;
                    }
                }
            }
        }
        return answer;
    }
}

class Node {
    int x, y, level;
    
    public Node(int i, int j, int lv) {
        x = i;
        y = j;
        level = lv;
    }
}