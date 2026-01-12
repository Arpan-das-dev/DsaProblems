package SlidingWindow;

/**
 * Utility class for solving the "Best Time to Buy and Sell Stock" problem.
 *
 * <p>Given an array of daily stock prices, find the maximum profit that can be achieved
 * by buying on one day and selling on a later day. Only one transaction is allowed.</p>
 *
 * <p><b>Approaches:</b></p>
 * <ul>
 *   <li><b>Brute Force:</b> For each day, check all future days and compute profit;
 *       keep track of the maximum profit found.</li>
 *   <li><b>Optimal (Single Pass):</b> Traverse the array once, keeping track of the
 *       minimum price seen so far and the maximum profit achievable at each step.</li>
 * </ul>
 *
 * <p>The optimal solution uses the idea that for each day, the best profit is
 * achieved by buying at the lowest price seen so far and selling at the current price.</p>
 *
 * <p><b>Time Complexity:</b> O(n²) for brute force, O(n) for optimal solution.<br>
 * <b>Space Complexity:</b> O(1) for both approaches.</p>
 *
 * @author Arpan Das
 * @since 12/01/2026
 */

public class BuyAndSellStocks {

    /**
     * Brute force solution to find maximum profit from a single buy-sell transaction.
     *
     * <p>For each buying day i, checks all future selling days j and computes the profit
     * as prices[j] - prices[i], updating the maximum profit found.</p>
     *
     * @param prices array of daily stock prices
     * @return the maximum profit achievable; 0 if no profit is possible or array is empty
     */

    public int maxProfitBrute(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int profit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j <prices.length ; j++) {
                int bought = prices[i];
                int sold = prices[j];
                profit = Math.max(profit,(sold-bought));
            }
        }
        return profit;
    }

    /**
     * Optimal single-pass solution to find maximum profit from a single buy-sell transaction.
     *
     * <p>Traverses the price array once, maintaining:
     * <ul>
     *   <li>minPrice: the lowest price seen so far ( the best day to buy)</li>
     *   <li>maxProfit: the maximum profit achievable so far</li>
     * </ul>
     * For each price, if it is lower than minPrice, update minPrice; otherwise, update
     * maxProfit with the profit from buying at minPrice and selling at current price.</p>
     *
     * @param prices array of daily stock prices
     * @return the maximum profit achievable; 0 if no profit is possible or array is empty
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) { // if it's the min value seen so far
                minPrice = price; // then set it as min price
            } else { // otherwise there is a chance of profit
                maxProfit = Math.max(maxProfit,price-minPrice); // updates only current profit is max
            }
        }
        return maxProfit;
    }
}
