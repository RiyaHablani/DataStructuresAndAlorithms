class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
            }
        }
        if (nums[n - 1] > nums[0]) {
            count++;
        }
        // If count is more than 1, then the array can't be sorted by rotation
        return count <= 1;
    }
}