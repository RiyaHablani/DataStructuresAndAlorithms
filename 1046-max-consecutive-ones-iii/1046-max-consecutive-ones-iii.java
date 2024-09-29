class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, count0 = 0, maxLength = 0;
        int n = nums.length;
        
        while (r < n) {
            if (nums[r] == 0) {
                count0++;
            }
            while (count0 > k) {
                if (nums[l] == 0) {
                    count0--;
                }
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}