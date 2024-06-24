class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length; // Length of the input array
        int count = 0; // Count of the flips needed
        int flip = 0; // To track the current flip state (whether we are in a flipped window or not)
        int[] isFlipped = new int[n]; // Array to mark where flips start

        for (int i = 0; i < n; i++) {
            // If the current index is beyond the first k elements,
            // update the flip state to remove the effect of flips that are out of the current window
            if (i >= k) {
                flip ^= isFlipped[i - k]; // Remove the effect of flips that are out of the current window
            }

            // Check if the current bit is 0 and it has not been flipped (or it's 1 and it has been flipped)
            if ((nums[i] ^ flip) == 0) {
                // If flipping would exceed the bounds of the array, return -1
                if (i + k > n) {
                    return -1; // It's impossible to flip all 0s to 1s
                }

                // Flip the current window
                flip ^= 1; // Toggle the flip state
                isFlipped[i] = 1; // Mark the start of the flip
                count++; // Increment the flip count
            }
        }

        return count; // Return the total number of flips needed
    }
}