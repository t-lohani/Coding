package dynamicprogramming;

public class BestTimeToBuyAndSellStocksWithCooldown {

	public static void main(String[] args) {
		int[] prices = {1,2,3,0,2};
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        
        int[] buy = new int[len];
        int[] sell = new int[len];
        int[] cool = new int[len];
        
        buy[0] = -1*prices[0];
        
        for (int i=1; i<len; i++) {
            buy[i] = Math.max(cool[i-1]-prices[i], buy[i-1]);
            sell[i] = Math.max(buy[i-1]+prices[i], sell[i-1]);
            cool[i] = Math.max(buy[i-1], Math.max(sell[i-1], cool[i-1]));
        }
        
        return Math.max(buy[len-1], Math.max(sell[len-1], cool[len-1]));
    }
}
