class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[] dp = new int[n];
        // Maximum profit up to each day
        dp[0] = 0;
        dp[1] = Math.max(0, prices[1] - prices[0]);

        for (int i = 2; i < n; i++) {
            // Option 1: Do nothing today
            dp[i] = dp[i - 1];
            // Option 2: Sell today
            for (int j = 0; j < i; j++) {
                int profit = prices[i] - prices[j];
                if (j > 1) {
                    profit += dp[j - 2];
                }
                dp[i] = Math.max(dp[i], profit);
            }
        }
        return dp[n - 1];
    }
}