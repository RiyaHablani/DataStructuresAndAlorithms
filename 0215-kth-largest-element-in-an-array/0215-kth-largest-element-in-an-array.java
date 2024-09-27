class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // default is min-heap

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) { 
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}