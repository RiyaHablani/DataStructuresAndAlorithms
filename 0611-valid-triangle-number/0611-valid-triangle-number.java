class Solution {
    public int triangleNumber(int[] nums) {
        // Sort the array to simplify the problem
        Arrays.sort(nums);
        int count = 0;
        
        // Iterate over the array from the end to the beginning
        // Start from the third last element to ensure at least three elements for a triangle
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0;          // Left pointer starts from the beginning of the array
            int right = i - 1;     // Right pointer starts just before the current element i
            
            // Use two pointers to find valid triangles
            while (left < right) {
                // Check if nums[left] + nums[right] > nums[i]
                // If true, then nums[left], nums[right], and nums[i] can form a triangle
                if (nums[left] + nums[right] > nums[i]) {
                    // All pairs (left, right) where left < right form triangles with nums[i]
                    count += right - left;
                    right--;                // Decrease right to find other valid pairs
                } else {
                    left++;                 // Increase left to try larger values of nums[left]
                }
            }
        }
        
        return count;  // Return the total count of valid triangles
    }
}