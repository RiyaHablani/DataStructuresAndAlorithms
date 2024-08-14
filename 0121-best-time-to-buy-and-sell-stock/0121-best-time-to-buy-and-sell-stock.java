class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0],n=prices.length,max=0,sell=0;
        for(int i=1;i<n;i++){
            if(prices[i]>buy){
                sell=prices[i]-buy;
                max=Math.max(sell,max);
            }else if(prices[i]<buy){
                buy=prices[i];
            }
        }
        return max;
    }
}