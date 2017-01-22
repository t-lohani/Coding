/*
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * */

package dynamicprogramming;

public class ArithmeticSlices {

	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,5,5,5,7,9,11,13,19,25,31};
		System.out.println(numberOfArithmeticSlices(A));
	}

	public static int numberOfArithmeticSlices(int[] A) {
        
        if (A.length < 3) {
            return 0;
        }
        
        int answer = 0;
        int streak = 2;
        int diff = A[1]-A[0];
        
        for (int i=2; i<A.length; i++) {
            if (A[i]-A[i-1] == diff) {
                streak++;
            } else {
                if (streak > 2) {
                    answer += (streak-2)*(streak-1)/2;
                }
                streak = 2;
                diff = A[i] - A[i-1];
            }
            
            if (i==A.length-1) {
                answer += (streak-2)*(streak-1)/2;
            }
        }
        
        return answer;
    }

}
