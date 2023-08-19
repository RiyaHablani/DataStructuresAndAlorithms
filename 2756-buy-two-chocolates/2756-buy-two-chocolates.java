class Solution {
    public int buyChoco(int[] prices, int money) {
       Arrays.sort(prices);
        int amount = money - (prices[0] + prices[1]);
        
        return amount < 0 ? money : amount;
    }
}