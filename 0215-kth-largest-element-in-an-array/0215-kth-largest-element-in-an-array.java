import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap (PriorityQueue). By default, a PriorityQueue is a min-heap in Java.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Step 1: Add the first 'k' elements of the array to the min-heap
        // This ensures that we have a heap of size 'k' containing the 'k' largest elements so far.
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);  // Offer each number to the min-heap (heapify them)
        }
        
        // Step 2: Iterate through the rest of the array, starting from the k-th element
        for (int i = k; i < nums.length; i++) {
            // If the current number is greater than the smallest number in the heap
            // (which is at the root of the min-heap), then we need to replace it.
            if (nums[i] > minHeap.peek()) {
                // Step 3: Remove the smallest element (root of the heap)
                minHeap.poll();  
                // Step 4: Add the current element (nums[i]) into the min-heap
                minHeap.offer(nums[i]);
            }
        }
        
        // Step 5: The root of the min-heap is the kth largest element
        // The heap size will be exactly 'k' after processing all the elements,
        // and the root will be the kth largest element.
        return minHeap.peek();  // Peek returns the root (smallest element) of the min-heap
    }
}
