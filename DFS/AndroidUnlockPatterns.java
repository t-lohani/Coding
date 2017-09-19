package dfs;

public class AndroidUnlockPatterns {

	public static void main(String[] args) {
		System.out.println(numberOfPatterns(3, 7));
	}

	public static int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean[] visited = new boolean[10];
        
        int answer = 0;
        
        for (int i=m; i<=n; i++) {
            answer += doDFS(visited, skip, 1, i-1) * 4;
            answer += doDFS(visited, skip, 2, i-1) * 4;
            answer += doDFS(visited, skip, 5, i-1);
        }
        
        return answer;
    }
    
    public static int doDFS(boolean[] visited, int[][] skip, int num, int rem) {
        if (rem == 0) {
            return 1;
        } else if (rem < 0) {
            return 0;
        }
        
        visited[num] = true;
        int ret = 0;
        for(int i = 1; i <= 9; ++i) {
            if(!visited[i] && (skip[num][i] == 0 || (visited[skip[num][i]]))) {
                ret += doDFS(visited, skip, i, rem - 1);
            }
        }
        visited[num] = false;
        return ret;
    }
}
