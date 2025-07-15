import java.util.Arrays;

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        // 3D DP table: dp[r1][c1][c2]
        // r2 is derived from r1 + c1 - c2
        int[][][] dp = new int[n][n][n];

        // Initialize DP with minimum values
        for (int[][] layer : dp)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE);

        // Start recursion from (0,0) for both persons
        return Math.max(0, collectCherries(grid, 0, 0, 0, dp));
    }

    // r1, c1: first person position
    // c2: second person column
    // r2 = r1 + c1 - c2 (because both have taken same number of steps)
    private int collectCherries(int[][] grid, int r1, int c1, int c2, int[][][] dp) {
        int n = grid.length;
        int r2 = r1 + c1 - c2;

        // Check if any position is out of bounds or on a thorn (-1)
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -1;  // Invalid path
        }

        // Reached bottom-right corner
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];  // Only one person collects cherry
        }

        // Check if already calculated
        if (dp[r1][c1][c2] != Integer.MIN_VALUE) {
            return dp[r1][c1][c2];
        }

        int cherries = 0;

        // If both are at the same cell, collect only once
        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        // Try all 4 move combinations:
        // (down, down), (right, right), (down, right), (right, down)
        int maxNext = Math.max(
            Math.max(collectCherries(grid, r1 + 1, c1, c2 + 1, dp),  // ↓ →
                     collectCherries(grid, r1, c1 + 1, c2 + 1, dp)), // → →
            Math.max(collectCherries(grid, r1 + 1, c1, c2, dp),      // ↓ ↓
                     collectCherries(grid, r1, c1 + 1, c2, dp))      // → ↓
        );

        // If all moves are blocked
        if (maxNext == -1) {
            dp[r1][c1][c2] = -1;
            return -1;
        }

        // Save and return result
        dp[r1][c1][c2] = cherries + maxNext;
        return dp[r1][c1][c2];
    }
}
