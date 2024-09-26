class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Initialize result with -1 for all elements
        Arrays.fill(result, -1);

        // Iterate over each element in the array
        for (int i = 0; i < n; i++) {
            // Check the next elements circularly
            for (int j = 1; j < n; j++) {
                if (nums[(i + j) % n] > nums[i]) {
                    result[i] = nums[(i + j) % n];
                    break;
                }
            }
        }

        return result;
    }
}