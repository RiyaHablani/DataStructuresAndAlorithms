class Number implements Comparable<Number>{
    int element;
    int freq;
    Number(int element,int freq){
        this.element=element;
        this.freq=freq;
    }
    public int compareTo(Number that){
        return this.freq-that.freq;//inc order;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number> pq=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            Number number=new Number(entry.getKey(),entry.getValue());
            pq.offer(number);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int res[]=new int[k];
        int index=0;
        while(pq.size()>0){
            Number number=pq.poll();
            res[index]=number.element;
            index++;
        }
        return res;
    }
}