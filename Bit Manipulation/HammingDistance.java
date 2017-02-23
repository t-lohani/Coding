/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.
 * */

package bitmanipulation;

public class HammingDistance {

	public static void main(String[] args) {
		int x = 1;
		int y = 4;
		
		System.out.println(hammingDistance(x, y));
	}
	
	public static int hammingDistance(int x, int y) {
        int xor = x^y;
        int mask;
        int answer = 0;
        for (int i=0; i<32; i++) {
            mask = 1 << i;
            if ((xor & mask) == mask) {
                answer++;
            }
        }
        
        return answer;
    }

}
