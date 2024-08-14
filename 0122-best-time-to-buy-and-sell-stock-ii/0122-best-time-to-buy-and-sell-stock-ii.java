class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
        long[][] dp = new long[n][2];
        
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        if (n == 0)
            return 0;

        return (int)getMaximumProfitUtil(prices, 0, 0, n, dp);
    }

    static long getMaximumProfitUtil(int[] prices, int ind, int buy, int n, long[][] dp) {
        if (ind == n) {
            return 0;
        }

        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        long profit;

        if (buy == 0) {
            profit = Math.max(-prices[ind] + getMaximumProfitUtil(prices, ind + 1, 1, n, dp),
                              0 + getMaximumProfitUtil(prices, ind + 1, 0, n, dp));
        } else {
            profit = Math.max(prices[ind] + getMaximumProfitUtil(prices, ind + 1, 0, n, dp),
                              0 + getMaximumProfitUtil(prices, ind + 1, 1, n, dp));
        }

        dp[ind][buy] = profit;
        return profit;
    }
}
