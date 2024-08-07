class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         if (nums == null || nums.length == 0 || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // Max heap

        for (int i = 0; i < n; i++) {
            // Add the current element to the heap
            pq.offer(new int[]{nums[i], i});

            // Remove elements not in the sliding window
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            // The first valid maximum element for the sliding window of size k
            if (i >= k - 1) {
                result[i - k + 1] = pq.peek()[0];
            }
        }

        return result;
    }
}