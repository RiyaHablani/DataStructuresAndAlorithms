import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Find the minimum and maximum values in the array
        int minValue = Arrays.stream(nums).min().getAsInt();
        int maxValue = Arrays.stream(nums).max().getAsInt();

        // Create a counting array to store the frequency of each number
        int[] count = new int[maxValue - minValue + 1];

        // Populate the count array based on the frequency of each number
        for (int num : nums) {
            count[num - minValue]++;
        }

        // Traverse the count array in reverse (from largest to smallest)
        int remaining = k; // Keep track of how many elements we need
        for (int i = count.length - 1; i >= 0; i--) {
            remaining -= count[i]; // Reduce the count by the frequency of the current number

            // If remaining becomes <= 0, we found the kth largest element
            if (remaining <= 0) {
                return i + minValue; // Map back to the original number
            }
        }

        // This line will never be reached due to valid input constraints
        return -1;
    }
}
