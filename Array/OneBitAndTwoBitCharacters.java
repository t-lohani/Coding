package array;

public class OneBitAndTwoBitCharacters {

	public static void main(String[] args) {
		int[] bits = {1,1,1,0};
		System.out.println(isOneBitCharacter(bits));
	}

	public static boolean isOneBitCharacter(int[] bits) {
        boolean[] vis = new boolean[bits.length];
        int i=0;
        
        while (i < bits.length) {
            if (bits[i] == 0)
                vis[i] = true;
            else {
                i++;
            }
            i++;
        }
        
        return vis[bits.length-1];
    }
}
