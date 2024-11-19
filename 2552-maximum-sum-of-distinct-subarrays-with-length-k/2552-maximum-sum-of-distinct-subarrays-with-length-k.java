class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, sum = 0;
        int i = 0, j = 0;
        HashSet<Integer> set = new HashSet<>();

        while (i < nums.length) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                sum += nums[i];
                i++;
                if (i - j == k) {
                    maxSum = Math.max(maxSum, sum);
                    set.remove(nums[j]);
                    sum -= nums[j];
                    j++;
                }
            } else {
                set.remove(nums[j]);
                sum -= nums[j];
                j++;
            }
        }
        return maxSum;
    }
}