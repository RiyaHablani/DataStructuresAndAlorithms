class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);
        for(int i=0;i<nums.length;i++){
            maxheap.add(nums[i]);
        }
        for(int i=0;i<k-1;i++){
            maxheap.poll();
        }
        return maxheap.peek();
    }
}