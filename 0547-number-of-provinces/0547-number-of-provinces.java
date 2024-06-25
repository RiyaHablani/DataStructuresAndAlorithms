class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // Number of cities
        boolean[] visited = new boolean[n]; // Array to keep track of visited cities
        int provinceCount = 0; // Counter for number of provinces
        
        // Iterate through each city
        for (int i = 0; i < n; i++) {
            // If the city has not been visited, it means we found a new province
            if (!visited[i]) {
                // Perform DFS to visit all cities in this province
                dfs(isConnected, visited, i);
                // Increment the province counter
                provinceCount++;
            }
        }
        
        return provinceCount; // Return the total number of provinces
    }
    public void dfs(int[][] isConnected,boolean[] visited,int i){
        // Mark the current city as visited
        visited[i] = true;
        
        // Iterate through all cities to find connections
        for (int j = 0; j < isConnected.length; j++) {
            // If city i is connected to city j and city j has not been visited
            if (isConnected[i][j] == 1 && !visited[j]) {
                // Recursively visit city j
                dfs(isConnected, visited, j);
            }
        }
    }
}