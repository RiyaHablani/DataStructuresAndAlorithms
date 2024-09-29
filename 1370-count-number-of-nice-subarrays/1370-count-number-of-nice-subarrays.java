class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for (int num : nums) {
            if (num % 2 == 1) {
                num = 1;
            } else {
                num = 0;
            }
        }

        return numSubarraysWithSum(nums, k);
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }

    public int helper(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while (r < nums.length) {
            sum = sum + (nums[r] % 2);
            while (sum > goal) {
                sum = sum - (nums[l] % 2);
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}