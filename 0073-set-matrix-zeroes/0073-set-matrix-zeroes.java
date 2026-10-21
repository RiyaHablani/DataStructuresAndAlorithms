class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int firstRow[] = new int[m];
        int firstCol[] = new int[n];

        Arrays.fill(firstRow, 1);
        Arrays.fill(firstCol, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    firstRow[i] = 0;
                    firstCol[j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (firstRow[i] == 0 || firstCol[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}