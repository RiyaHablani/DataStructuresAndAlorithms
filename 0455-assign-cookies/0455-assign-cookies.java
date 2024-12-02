class Solution {
    public int findContentChildren(int[] greed, int[] cookie) {
        // Initialize pointers and count
        int i = 0, j = 0, count = 0;

        // Sort both arrays to facilitate greedy assignment
        Arrays.sort(greed);
        Arrays.sort(cookie);

        // Iterate through greed and cookie arrays
        while (i < greed.length && j < cookie.length) {
            // If the cookie satisfies the greed level
            if (cookie[j] >= greed[i]) {
                count++; // Increment the count of satisfied children
                i++;     // Move to the next child
            }
            j++;         // Move to the next cookie
        }
        return count;
    }
}
