class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize the result array with -1 (default for no greater element)
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        // Traverse the array twice to simulate the circular behavior
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n]; // Assign next greater element
            }
            if (i < n) {
                stack.push(i); // Push only first-pass indices
            }
        }

        return result;
    }
}
