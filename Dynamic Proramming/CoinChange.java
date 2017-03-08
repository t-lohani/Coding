/*
 *  You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin. 
 * */

package dynamicprogramming;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = {2, 3, 5};
		int amount = 437;
		
		System.out.println(coinChange(coins, amount));
	}

	public static int coinChange(int[] coins, int amount) {
        int[] denomination = new int[amount+1];
        int[] coinVal = new int[amount+1];
        denomination[0] = 0;
        for(int i=1; i<denomination.length; i++) {
            denomination[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0; i<coinVal.length; i++) {
            coinVal[i] = -1;
        }
        
        for(int i=0; i<coins.length; i++) {
            for(int j=1; j<denomination.length; j++) {
                if(coins[i]<=j) {
                    if(j-coins[i]>=0 && denomination[j]>denomination[j-coins[i]]+1 && denomination[j-coins[i]]!=Integer.MAX_VALUE) {
                        denomination[j] = denomination[j-coins[i]]+1;
                        coinVal[j] = coins[i];
                    }
                }
            }
        }
        
        return denomination[amount]!=Integer.MAX_VALUE?denomination[amount]:-1;
    }
}
