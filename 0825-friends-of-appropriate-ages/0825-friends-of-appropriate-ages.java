class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int a = ages[i];
            if (a < 15) continue; // age too small to send requests

            int low = (int)(0.5 * a + 7) + 1;
            int high = a;

            int left = lowerBound(ages, low);
            int right = upperBound(ages, high);

            total += (right - left); // people in range
            total -= 1; // exclude self
        }

        return total;
    }

    // first index with value >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    // first index with value > target
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
