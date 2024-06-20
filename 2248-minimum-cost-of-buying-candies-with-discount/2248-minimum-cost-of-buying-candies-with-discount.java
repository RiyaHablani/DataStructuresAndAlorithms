class Solution {
    public int minimumCost(int[] cost) {
       // Sort the array in descending order
        Arrays.sort(cost);
        int n = cost.length;
        int sum = 0;
        
        for (int i = n - 1; i >= 0; i -= 3) {
            // Add the first candy in the current triplet
            sum += cost[i];
            // Add the second candy in the current triplet if it exists
            if (i - 1 >= 0) {
                sum += cost[i - 1];
            }
            // The third candy in the current triplet is free and thus not added to the sum
        }
        
        return sum;
    }
}