class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        
        // Find the first non-negative number's index
        int firstNonNegative = binarySearch(nums, 0);
        
        // Find the first positive number's index
        int firstPositive = binarySearch(nums, 1);
        
        // Number of negatives and positives
        int negCount = firstNonNegative; // All elements before first non-negative
        int posCount = n - firstPositive; // All elements after the first positive
        
        return Math.max(negCount, posCount);
    }

    // Binary search helper
    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}