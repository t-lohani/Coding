package dfs;

public class SmallestRectangleEnclosingBlackPixels {

	public static void main(String[] args) {
		char[][] image = {{'0', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '1', '0', '0'}};
		int x = 0;
		int y = 0;
		
		System.out.println(minArea(image, x, y));
	}

	static int minX = Integer.MAX_VALUE;
	static int maxX = Integer.MIN_VALUE;
	static int minY = Integer.MAX_VALUE;
	static int maxY = Integer.MIN_VALUE;
    
    public static int minArea(char[][] image, int x, int y) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        doDfs(image, x, y, visited);
        
        return (maxX-minX+1) * (maxY-minY+1);
    }
    
    public static void doDfs(char[][] image, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        
        int[] xArr = {1, -1, 0, 0};
        int[] yArr = {0, 0, 1, -1};
        
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        
        for (int i=0; i<4; i++) {
            if (x+xArr[i] >= 0 && x+xArr[i] < image.length 
                && y+yArr[i] >= 0 && y+yArr[i] < image[0].length 
                && !visited[x+xArr[i]][y+yArr[i]]
                && image[x+xArr[i]][y+yArr[i]] == '1') {
                doDfs(image, x+xArr[i], y+yArr[i], visited);
            }
        }
    }
}
