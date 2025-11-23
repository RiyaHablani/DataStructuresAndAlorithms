class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;

        for (int x : aliceSizes) sumA += x;
        for (int y : bobSizes) sumB += y;

        int diff = (sumB - sumA) / 2; // y = x + diff

        Arrays.sort(bobSizes); // for binary search

        for (int x : aliceSizes) {
            int y = x + diff;
            if (binarySearch(bobSizes, y)) {
                return new int[]{x, y};
            }
        }
        return new int[0];
    }

    private boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}