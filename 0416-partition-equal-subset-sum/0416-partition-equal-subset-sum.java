class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum % 2 != 0) return false;
        
        int k = sum / 2;
        return helper(nums, k);
    }

    public boolean helper(int[] nums, int k) {
        int n = nums.length;
        boolean dp[][] = new boolean[n][k + 1];

       
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= k) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean nontaken = dp[i - 1][j];
                boolean taken = false;
                if (nums[i] <= j) {
                    taken = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = taken || nontaken;
            }
        }
        return dp[n - 1][k];
    }
}