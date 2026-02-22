 
 class Solution{
    public int maximalRectangle(char[][] matrix) {
        // Handle edge cases: empty or null matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        // 'heights' array stores the current histogram for the row being processed.
        // heights[j] will store the number of consecutive '1's ending at (current_row, j)
        int[] heights = new int[cols];

        // Iterate through each row of the matrix
        for (int i = 0; i < rows; i++) {
            // Update the heights array based on the current row's values
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++; // If '1', increment the height for this column
                } else {
                    heights[j] = 0; // If '0', reset the height for this column
                }
            }
            
            // Calculate the largest rectangle area in the histogram formed by the current 'heights' array
            // and update the overall maximum area found so far.
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

   
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>(); // Stores indices of bars in increasing order of height
        int maxRectArea = 0;
        int n = heights.length;

        // Iterate through all bars. The loop goes up to n (inclusive) to process
        // all remaining elements in the stack by effectively adding a sentinel bar of height 0.
        for (int i = 0; i <= n; i++) {
            // Get the current height. If i == n, it's a virtual bar of height 0 to clear the stack.
            int currentHeight = (i == n) ? 0 : heights[i];

            // While the stack is not empty AND the bar at stack's top is taller or equal to currentHeight,
            // we can potentially form a rectangle with the popped bar using 'currentHeight' as its right boundary.
            while (!stack.isEmpty() && heights[stack.peek()] >= currentHeight) {
                int h = heights[stack.pop()]; // Height of the bar just popped
                
                // Calculate the width for this popped bar 'h'.
                // If the stack is empty, it means 'h' is the shortest bar to its left,
                // so its rectangle extends from index 0 to 'i-1'. Its width is 'i'.
                // If the stack is not empty, 'stack.peek()' is the index of the first bar smaller than 'h' to its left.
                // The width for 'h' is from the index after 'stack.peek()' up to 'i-1'.
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                maxRectArea = Math.max(maxRectArea, h * w);
            }
            // Push the current bar's index onto the stack.
            stack.push(i);
        }
        return maxRectArea;
    }
}