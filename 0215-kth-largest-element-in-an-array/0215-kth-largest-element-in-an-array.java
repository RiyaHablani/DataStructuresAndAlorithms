class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>((a,b)->(b-a));

        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
        }
        while((k-1)>0){
            minHeap.remove();
            k--;
        }
        return minHeap.peek();
    }
}