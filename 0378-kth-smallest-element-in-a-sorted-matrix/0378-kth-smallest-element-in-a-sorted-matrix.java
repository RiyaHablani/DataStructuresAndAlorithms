class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0]; // Smallest element in the matrix
        int high = matrix[n - 1][n - 1]; // Largest element in the matrix

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Count how many elements are <= mid
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1; // Need more elements, move low up
            } else {
                high = mid; // Found sufficient elements, tighten high
            }
        }

        return low; // low and high converge to the kth smallest element
    }

    private int countLessEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1; // Start from the bottom-left corner
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += (row + 1); // All elements in this column up to the current row are <= target
                col++; // Move to the next column
            } else {
                row--; // Move to the previous row
            }
        }

        return count;
    }
}
