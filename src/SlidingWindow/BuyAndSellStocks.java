package SlidingWindow;

public class BuyAndSellStocks {

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
