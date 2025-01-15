class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Use a max-heap to always access the largest number efficiently
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all the gifts to the priority queue
        for (int gift : gifts) {
            max.add(gift);
        }
        //4,9,25,64,100=>4,9,25,64,10=>4,9,25,8,10=>4,9,5,8,10=>4,9,5,8,3
        // Perform the operation `k` times
        for (int i = 0; i < k; i++) {
            int largestGift = max.poll(); // Get the largest gift
            int reducedGift = (int) Math.sqrt(largestGift); // Compute the square root
            max.add(reducedGift); // Add the reduced value back to the heap
        }
        
        // Calculate the total sum of the gifts
        long totalGifts = 0;
        while (!max.isEmpty()) {
            totalGifts += max.poll();
        }
        
        return totalGifts;
    }
}
