class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int buy = prices[0]; 
        int maxProfit = 0;    
        for (int i = 1; i < n; i++) {
            if (prices[i] < buy) {
                buy = prices[i]; // Update buy if we find a lower price
            } else if (prices[i] > buy + fee) {
                maxProfit += prices[i] - buy - fee; // Sell the stock and update maxProfit
                buy = prices[i] - fee; // Update buy to account for the fee
            }
        }
        
        return maxProfit;
    }
}