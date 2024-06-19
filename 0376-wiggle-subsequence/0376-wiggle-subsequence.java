class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int count = 1; // At least one element is always a part of the wiggle sequence
        int prevDiff = 0;
        int currDiff;

        for (int i = 1; i < nums.length; i++) {
            currDiff = nums[i] - nums[i - 1];
            // Check if the current difference is a valid wiggle
            if ((currDiff > 0 && prevDiff <= 0) || (currDiff < 0 && prevDiff >= 0)) {
                count++;
                prevDiff = currDiff; // Update prevDiff only when a wiggle is found
            }
        }

        return count;
    }
}