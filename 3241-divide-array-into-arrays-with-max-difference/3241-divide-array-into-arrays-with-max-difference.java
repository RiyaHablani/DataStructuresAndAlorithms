class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums); // Sort the input array to group close elements together
        int n = nums.length; // Get length of the input array
        int m = n / 3; // Calculate the number of groups needed
        int[][] res = new int[m][3]; // Initialize the result 2D array

        for (int i = 0; i < m; i++) { // Loop over each group
            int idx = i * 3; // Calculate the starting index for this group
            if (nums[idx + 2] - nums[idx] > k) { // If max difference in the group is greater than k
                return new int[0][0]; // Return empty array as it is not possible
            }
            res[i][0] = nums[idx]; // Assign first element of the group
            res[i][1] = nums[idx + 1]; // Assign second element of the group
            res[i][2] = nums[idx + 2]; // Assign third element of the group
        }
        return res; // Return the grouped result
    }
}