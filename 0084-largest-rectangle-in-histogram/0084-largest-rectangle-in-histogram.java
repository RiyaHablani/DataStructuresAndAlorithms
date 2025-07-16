class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        // left[i] stores index of previous smaller element for heights[i]
        int[] left = new int[n];

        // right[i] stores index of next smaller element for heights[i]
        int[] right = new int[n];

        // Fill left[]: for each bar, find the index of previous smaller height
        for (int i = 0; i < n; i++) {
            int j = i - 1;

            // Keep jumping left while the previous height is greater or equal
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];  // use already calculated left[] to jump quickly
            }

            left[i] = j; // store the previous smaller index
        }

        // Fill right[]: for each bar, find the index of next smaller height
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;

            // Keep jumping right while the next height is greater or equal
            while (j < n && heights[j] >= heights[i]) {
                j = right[j];  // use already calculated right[] to jump quickly
            }

            right[i] = j; // store the next smaller index
        }

        // Calculate max rectangle area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            // Width of rectangle = right boundary - left boundary - 1
            int width = right[i] - left[i] - 1;

            // Area = height * width
            int area = heights[i] * width;

            // Update max area if this one is larger
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
