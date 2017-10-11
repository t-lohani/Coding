package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {

	public static void main(String[] args) {
		int[][] grid = {{0,0,1,0,1,0,1,1,1,0,0,0,0,1,0,0,1,0,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1,1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0},
				{0,0,1,0,0,1,1,1,0,0,1,0,1,0,0,1,1,0,0,1,0,0,0,1,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,1,0,1,1,0,1,0,0,0},
				{0,1,0,1,0,1,1,1,0,0,1,1,0,0,0,0,1,0,1,0,1,1,1,0,1,1,1,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1,0,0,1,0,0,1,0},
				{1,0,1,0,0,1,0,1,0,0,1,0,0,1,1,1,0,1,0,0,0,0,1,0,1,0,0,1,0,1,1,1,0,1,0,0,0,1,1,1,0,0,0,0,1,1,1,1,1,1}};
		
		System.out.println(numDistinctIslands(grid));
	}

	public static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public static int numDistinctIslands(int[][] grid) {
        Set<List<List<Integer>>> set = new HashSet<>();
        
        int len = grid.length;
        if (len == 0)
            return 0;
        int wid = grid[0].length;
        
        for (int i=0; i<len; i++) {
            for (int j=0; j<wid; j++) {
                if (grid[i][j] == 1) {
                    List<List<Integer>> list = new ArrayList<>();
                    doDfs(i, j, i, j, grid, list, len, wid);
                    if (list.size() != 0) {
                        set.add(list);
                    }
                }
            }
        }
        
        return set.size();
    }
    
    public static void doDfs(int curX, int curY, int prevX, int prevY, int[][] grid, List<List<Integer>> list, int len, int wid) {
        if (curX >= 0 && curY >= 0 && curX < len && curY < wid && grid[curX][curY] == 1) {
            list.add(Arrays.asList(curX - prevX, curY - prevY));
            grid[curX][curY] = 0;
            for (int i=0; i<4; i++) {
                int newX = curX + dir[i][0];
                int newY = curY + dir[i][1];
                doDfs(newX, newY, prevX, prevY, grid, list, len, wid);
            }
        }
    }
}
