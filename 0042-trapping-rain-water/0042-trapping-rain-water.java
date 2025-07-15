class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;          // left pointer
        int right = n - 1;     // right pointer
        int leftMax = 0;       // max height to the left
        int rightMax = 0;      // max height to the right
        int water = 0;         // total water trapped

        // Process until pointers meet
        while (left < right) {
            if (height[left] < height[right]) {
                // Left is smaller, process left side
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // update max
                } else {
                    water += leftMax - height[left];  // trap water
                }
                left++;
            } else {
                // Right is smaller, process right side
                if (height[right] >= rightMax) {
                    rightMax = height[right];  // update max
                } else {
                    water += rightMax - height[right];  // trap water
                }
                right--;
            }
        }

        return water;
    }
}
