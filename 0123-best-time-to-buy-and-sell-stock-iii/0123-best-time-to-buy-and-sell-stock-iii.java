class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[] left = new int[n];   // Max profit till i
        int[] right = new int[n];  // Max profit from i

        // Fill left[]
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }

        // Fill right[]
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
        }

        // Combine: max of left[i] + right[i]
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }
}
