class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int max1 = robRange(nums, 0, n - 2);
        
        int max2 = robRange(nums, 1, n - 1);

        return Math.max(max1, max2);
    }

    private int robRange(int[] nums, int start, int end) {
        if (start == end) return nums[start];

        int prev2 = 0;
        int prev1 = 0;
        int curr = 0;

        for (int i = start; i <= end; i++) {
            curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}