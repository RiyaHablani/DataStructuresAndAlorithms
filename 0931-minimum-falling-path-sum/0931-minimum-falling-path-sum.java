class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        // Base case: copy the first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int up = dp[i - 1][j];
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if (j > 0) {
                    left = dp[i - 1][j - 1];
                }

                if (j < n - 1) {
                    right = dp[i - 1][j + 1];
                }

                dp[i][j] = matrix[i][j]
                        + Math.min(up, Math.min(left, right));
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            answer = Math.min(answer, dp[m - 1][j]);
        }

        return answer;
    }
}