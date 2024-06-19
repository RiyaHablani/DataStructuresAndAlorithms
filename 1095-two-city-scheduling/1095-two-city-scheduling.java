class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // non-ascending sort by the cost difference between destination a and b
        Arrays.sort(costs, (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]));
        int totalCost = 0, n = costs.length / 2, aCount = 0, bCount = 0;
        for(int i = 0; i < costs.length; ++i) {
            if(aCount == n) {
                totalCost += costs[i][1];
            } else if(bCount == n) {
                totalCost += costs[i][0];
            } else {
                if(costs[i][0] < costs[i][1]) {
                    totalCost += costs[i][0];
                    aCount += 1;
                } else {
                    totalCost += costs[i][1];
                    bCount += 1;
                }
            }
        }
        return totalCost;
    }
}