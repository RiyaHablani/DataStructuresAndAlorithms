class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];

        // Count degree of each city
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        // Store cities
        Integer[] cities = new Integer[n];
        for (int i = 0; i < n; i++) {
            cities[i] = i;
        }

        // Sort cities by degree (ascending)
        Arrays.sort(cities, (a, b) -> degree[a] - degree[b]);

        // Assign values
        int[] value = new int[n];
        int cur = 1;
        for (int city : cities) {
            value[city] = cur++;
        }

        // Calculate total importance
        long ans = 0;
        for (int[] road : roads) {
            ans += value[road[0]] + value[road[1]];
        }

        return ans;
    }
}