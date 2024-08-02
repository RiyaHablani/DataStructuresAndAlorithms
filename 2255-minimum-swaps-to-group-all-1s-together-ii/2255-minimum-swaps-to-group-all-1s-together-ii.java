class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int count = 0; 

        for (int num : nums) {
            if (num == 1) count++;
        }
        if (count == 0 || count == n) return 0;
        int minSwaps = Integer.MAX_VALUE;
        int zerosInWindow = 0;
        int[] extendedArray = new int[2 * n];
        for (int i = 0; i < n; i++) {
            extendedArray[i] = nums[i];
            extendedArray[i + n] = nums[i];
        }
        for (int i = 0; i < count; i++) {
            if (extendedArray[i] == 0) zerosInWindow++;
        }

        minSwaps = Math.min(minSwaps, zerosInWindow);
        for (int i = count; i < 2 * n; i++) {
            if (extendedArray[i] == 0) zerosInWindow++;
            if (extendedArray[i - count] == 0) zerosInWindow--;
            minSwaps = Math.min(minSwaps, zerosInWindow);
        }
        return minSwaps;
    }
}