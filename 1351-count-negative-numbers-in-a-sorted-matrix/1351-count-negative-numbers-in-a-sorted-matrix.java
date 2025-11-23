class Solution {
    public int countNegatives(int[][] grid) {
        int total = 0;
        for (int[] row : grid) {
            int left = 0;
            int right = row.length - 1;
            // binary search to find first negative
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (row[mid] < 0) {
                    // move left to find earlier negative
                    right = mid - 1;
                } else {
                    // row[mid] >= 0 → move right
                    left = mid + 1;
                }
            }
            // left is index of first negative
            total += (row.length - left);
        }

        return total;
    }
}