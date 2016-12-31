/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit.
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * */

package array;

public class BestTimeToBuyAndSellStocks2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = {10, 20, 15, 18, 14, 12, 17, 15, 19};
		System.out.println(maxProfit(prices));
	}
	
	public static int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;
            
        int answer = 0;
        
        for(int i=0; i<prices.length-1; i++) {
            if(prices[i]<prices[i+1]) {
                answer = answer + (prices[i+1]-prices[i]);
            }            
        }
        
        return answer;
    }

}
