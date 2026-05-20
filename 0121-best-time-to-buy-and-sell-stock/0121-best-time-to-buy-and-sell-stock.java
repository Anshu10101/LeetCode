class Solution {
    public int maxProfit(int[] prices) {
        int minPriceSoFar = Integer.MAX_VALUE; // Lowest price seen so far
        int maxProfit = 0; // Overall maximum profit
        int profitIfSoldToday = 0; // Profit if sold today

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPriceSoFar) {
                minPriceSoFar = prices[i]; // Update to the new lower price
            }
            profitIfSoldToday = prices[i] - minPriceSoFar; // Calculate profit
            if (maxProfit < profitIfSoldToday) {
                maxProfit = profitIfSoldToday; // Update max profit if current is better
            }
        }
        return maxProfit;
    }
}
