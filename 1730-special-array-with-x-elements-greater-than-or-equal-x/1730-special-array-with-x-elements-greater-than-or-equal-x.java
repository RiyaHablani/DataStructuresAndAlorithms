class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int start = 0;
        int end = n - 1; 

        // Check x = n separately (special case)
        int idxN = firstIndex(nums, n);
        if (n - idxN == n) { // all numbers >= n ?
            return n;
        }

        while (start <= end) {
            int x = start + (end - start) / 2;

            // Count how many numbers >= x
            int idx = firstIndex(nums, x);
            int count = n - idx;

            if (count == x) {
                return x;
            } else if (count < x) {
                end = x - 1;
            } else {
                start = x + 1;
            }
        }

        return -1;
    }

    // binary search to find 1st index where nums[i] >= target
    private int firstIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
