class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Stack to keep track of keys we need to use
        Stack<Integer> keys = new Stack<>();
        // Set to keep track of rooms we've visited
        Set<Integer> visited = new HashSet<>();

        // Start with room 0
        visited.add(0);
        // Add all keys found in room 0 to the stack
        keys.addAll(rooms.get(0));

        // While there are keys to use
        while (!keys.isEmpty()) {
            // Get the next key
            int key = keys.pop();

            // If we haven't visited the room corresponding to this key
            if (!visited.contains(key)) {
                // Mark this room as visited
                visited.add(key);
                // Add all keys found in this room to the stack
                keys.addAll(rooms.get(key));
            }
        }

        // Check if we've visited all the rooms
        return visited.size() == rooms.size();
    }
}