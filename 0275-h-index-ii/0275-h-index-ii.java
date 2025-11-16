class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int h = n - mid; // papers count from mid to end
            if (citations[mid] >= h) {
                end = mid - 1; // try to find bigger h
            } else {
                start = mid + 1;
            }
        }

        return n - start;
    }
}
