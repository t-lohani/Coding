/*
 * We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!

 * */

package divideandconquer;

public class GuessNumberHigherOrLower {

	public static void main(String[] args) {

	}

	public static int guessNumber(int n) {
        int ans = 0;
        
        double low = 1;
        double high = (double) n+1;
        double mid;
        while(high>=low) {
            mid = (high+low)/2;
            if(guess((int) mid)==-1) {
                high = mid;
            } else if(guess((int) mid)==1) {
                low = mid;
            } else {
                ans = (int) mid;
                break;
            }
        }
        
        return ans;
    }
	
	public static int guess(int num) {
		// Defined in the problem
		return 0;
	}
}
