import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Create a Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add all elements of the matrix into the heap
        for (int[] row : matrix) {
            for (int num : row) {
                minHeap.offer(num);
            }
        }

        // Extract the smallest element from the heap k times
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = minHeap.poll();
        }

        return result;
    }
}
