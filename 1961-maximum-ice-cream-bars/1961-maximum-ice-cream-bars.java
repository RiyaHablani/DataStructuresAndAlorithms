class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs); // Sort costs to ensure we are buying the cheapest ice creams first
        int sum = 0;
        int count = 0;
        
        for (int i = 0; i < costs.length; i++) {
            if (sum + costs[i] <= coins) {
                sum += costs[i];
                count++;
            } else {
                break; // If we can't afford the next ice cream, exit the loop
            }
        }
        return count;
    }
}