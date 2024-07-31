class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int min=prices[0];
        int n=prices.length;
        for(int i=1;i<n;i++){
            int cost=prices[i]-min;
            maxProfit=Math.max(maxProfit,cost);
            min=Math.min(prices[i],min);
        }
        return maxProfit;
    }
}