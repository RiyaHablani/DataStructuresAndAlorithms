class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0; // Pointer to place the next non-zero element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap elements
                int temp = nums[i];
                nums[i] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = temp;
                lastNonZeroFoundAt++;
            }
        }
    }
}