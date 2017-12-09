package unionfind;

public class FriendCircles {

	public static void main(String[] args) {
		int[][] M = {{1,1,0},
				 	{1,1,0},
				 	{0,0,1}};
		System.out.println(findCircleNum(M));
	}

	public static int findCircleNum(int[][] M) {
        int[] par = new int[M.length];
        int answer = M.length;
        for (int i=0; i<par.length; i++) {
            par[i] = i;
        }
        
        for (int i=0; i<M.length; i++) {
            for (int j=i+1; j<M.length; j++) {
                if (M[i][j] == 1) {
                    int grp1 = find(i, par);
                    int grp2 = find(j, par);
                    
                    if (grp1 != grp2) {
                        par[grp2] = grp1;
                        answer--;
                    }
                }
            }
         }
        
        return answer;
    }
    
    public static int find(int pos, int[] par) {
        while (par[pos] != pos) {
            pos = par[pos];
        }
        
        return pos;
    }
}
