/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * */

package array;

public class BestTimeToBuyAndSellStocks {

	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
        
        if(prices.length == 0)
            return 0;
            
        int smallest = prices[0];
        int maxDifference = 0;
        
        for(int i=0; i<prices.length; i++) {
            if(prices[i] < smallest)
                smallest = prices[i];
                
            prices[i] = prices[i] - smallest;
            if(prices[i] > maxDifference)
                maxDifference = prices[i];
        }
        
        return maxDifference;
    }

}
