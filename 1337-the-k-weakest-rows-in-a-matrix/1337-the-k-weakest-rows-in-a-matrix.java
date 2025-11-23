class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int[][] strength = new int[m][2]; // [soldiers, rowIndex]
        for (int i = 0; i < m; i++) {
            int soldiers = countSoldiers(mat[i]);
            strength[i][0] = soldiers;
            strength[i][1] = i;
        }
        // sort by soldiers, then by row index
        Arrays.sort(strength, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = strength[i][1];   
        return ans;
    }
    // binary search to count soldiers (count of 1’s)
    private int countSoldiers(int[] row) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) left = mid + 1;   // move right
            else right = mid - 1;               // move left
        }
        return left; // number of 1's
    }
}