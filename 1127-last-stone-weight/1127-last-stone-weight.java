class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++){
            maxHeap.add(stones[i]);
        }
       
        while(maxHeap.size()>1){
            int a=maxHeap.poll();
            int b=maxHeap.poll();
            if(a!=b){
                maxHeap.add(a-b);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}