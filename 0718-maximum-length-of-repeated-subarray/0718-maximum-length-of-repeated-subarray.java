class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int maxLen = 0;

        // Slide A over B
        for (int offset = 0; offset < n; offset++) {
            maxLen = Math.max(maxLen, countMatch(A, B, offset, 0));
        }

        // Slide B over A
        for (int offset = 0; offset < m; offset++) {
            maxLen = Math.max(maxLen, countMatch(A, B, 0, offset));
        }

        return maxLen;
    }

    private int countMatch(int[] A, int[] B, int i, int j) {
        int count = 0, maxCount = 0;

        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
            i++;
            j++;
        }

        return maxCount;
    }
}
