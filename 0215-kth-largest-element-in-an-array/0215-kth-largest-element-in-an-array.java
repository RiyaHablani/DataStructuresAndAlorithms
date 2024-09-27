class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>((a,b)->(b-a));

        for(int i=0;i<nums.length;i++){
            maxHeap.add(nums[i]);
        }
        while((k-1)>0){
            maxHeap.remove();
            k--;
        }
        return maxHeap.peek();
    }
}