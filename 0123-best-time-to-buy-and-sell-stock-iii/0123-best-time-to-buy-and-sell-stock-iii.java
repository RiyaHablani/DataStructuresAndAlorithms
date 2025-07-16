class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            // Buy at lowest price
            buy1 = Math.max(buy1, -price);        // Spend money
            sell1 = Math.max(sell1, buy1 + price); // Sell after 1st buy
            buy2 = Math.max(buy2, sell1 - price); // Buy again after selling once
            sell2 = Math.max(sell2, buy2 + price); // Final sell
        }

        return sell2;
    }
}
