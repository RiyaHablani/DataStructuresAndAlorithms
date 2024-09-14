class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (isSorted(nums)) {
                return true;
            }
            rotate(nums);
        }
        return false;
    }
    
    // Function to check if the array is sorted
    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }

    // Function to rotate the array by 1 position
    private void rotate(int[] nums) {
        int first = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = first;
    }
}