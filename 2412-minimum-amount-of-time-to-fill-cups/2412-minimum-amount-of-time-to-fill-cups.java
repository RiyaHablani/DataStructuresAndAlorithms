class Solution {
    public int fillCups(int[] amount) {
        int count = 0;

        // Keep doing this until there's no water left to distribute
        while (amount[0] > 0 || amount[1] > 0 || amount[2] > 0) {
            // Find the two largest values to decrement
            Arrays.sort(amount);  // Sorting takes O(3) time
            amount[2]--;  // largest element
            amount[1]--;  // second largest element

            count++;  // Increment the count for each operation
        }

        return count;
    }
}
