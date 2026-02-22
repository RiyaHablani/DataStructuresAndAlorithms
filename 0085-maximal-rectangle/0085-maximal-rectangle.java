class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Handle edge cases: empty or null matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        // This array will store the heights of consecutive '1's for each column
        // treating the current row as the base of a histogram.
        int[] heights = new int[cols];

        // Iterate through each row of the matrix
        for (int i = 0; i < rows; i++) {
            // Update the heights array based on the current row
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++; // Increment height if it's a '1'
                    } else {
                    heights[j] = 0; // Reset height to 0 if it's a '0'
                }
            }
            // Calculate the largest rectangle area for the current histogram (heights array)
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    /**
     * Helper function to find the largest rectangle area in a histogram.
     * Uses a monotonic stack approach.
     *
     * @param heights An array representing the heights of bars in a histogram.
     * @return The maximum area of a rectangle that can be formed in the histogram.
      */
    private int largestRectangleArea(int[] heights) {
        // Create an extended heights array with a sentinel '0' at the end.
        // This ensures all elements in the stack are eventually processed and popped.
        int[] h = new int[heights.length + 1];
        System.arraycopy(heights, 0, h, 0, heights.length);
        h[heights.length] = 0; // Sentinel value

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>(); // Stores indices of bars

        // Iterate through the extended heights array
        for (int i = 0; i < h.length; i++) {
            // While the stack is not empty and the current bar's height is
            // less than or equal to the height of the bar at the stack's top
            while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                int height = h[stack.pop()]; // Pop the top bar's height
                
                // Calculate width:
                // If stack is empty, it means this popped bar is the shortest
                // till 'i', so it spans from index 0 to 'i-1'. Width = i.
                // If stack is not empty, the width is from the element
                // after stack.peek() up to 'i-1'.
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i); // Push the current bar's index onto the stack
        }
        return maxArea;
    }
}