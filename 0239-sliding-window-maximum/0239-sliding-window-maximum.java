class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Store indices of useful elements
        // The largest element will be at the front
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // Remove elements which are outside the window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // Remove smaller elements from the back
            // because current element is bigger
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // Add current index
            deque.addLast(i);
            // Window is ready when i >= k - 1
            if (i >= k - 1) {
                ans[index] = nums[deque.peekFirst()];
                index++;
            }
        }
        return ans;
    }
}