class Solution {
    public int findCenter(int[][] edges) {
        // If the edges array is null, return -1 as an error code
        if (edges == null) return -1;

        // Create a HashMap to store the frequency of each node
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through each edge in the edges array
        for (int[] edge : edges) {
            // Increment the count for the first node of the edge
            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            // Increment the count for the second node of the edge
            map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
        }

        // Iterate through the keys (nodes) in the map
        for (Integer key : map.keySet()) {
            // If the count of the node is equal to the number of edges, it is the center
            if (map.get(key) == edges.length) return key;
        }

        // If no center is found, return 0 (though the problem guarantees a center exists)
        return 0;
    }
}