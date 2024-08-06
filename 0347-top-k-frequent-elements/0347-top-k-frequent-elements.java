class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> map= new HashMap<>();

       for(int i=0;i<nums.length;i++){
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       }

       PriorityQueue<Integer> minHeap= new PriorityQueue<>((a,b)->Integer.compare(map.get(a),map.get(b)));

       for(int key: map.keySet()){
           minHeap.offer(key);
           if(minHeap.size()>k){
              minHeap.poll();
           }
       }

       int[] result= new int[k];
       int index=0;

       while(!minHeap.isEmpty()){
        result[index]=minHeap.poll();
        index++;
       }

       return result;
    }
}