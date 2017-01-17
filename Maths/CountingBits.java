/*
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * */

package maths;

public class CountingBits {

	public static void main(String[] args) {
		int[] answer = countBits(50);
		
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
	
	public static int[] countBits(int num) {
        int[] answer = new int[num+1];
        int pointer = 0;
        answer[0] = 0;
        if (num == 0) {
            return answer;
        }
        answer[1] = 1;
        
        for (int i=2; i<=num; i++) {
            if (((i)&(i-1)) == 0) {
                pointer = 0;
            }
            answer[i] = answer[pointer] + 1;
            pointer++;
        }
        
        return answer;
    }

}
