class Solution {
    public boolean canJump(int[] nums) {
        // Farthest index we can reach
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // If current index is beyond our reach,
            // we cannot move further
            if (i > maxReach) {
                return false;
            }
            // Find the farthest place we can reach
            maxReach = Math.max(maxReach, i + nums[i]);
            // If we can reach the last index
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}