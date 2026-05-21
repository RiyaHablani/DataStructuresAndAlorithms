class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        for(int i=0;i<gifts.length;i++){
            pq.offer(gifts[i]);
        }
        int j=0;
        while(j<k){
            int currIndexVal=pq.poll();
            currIndexVal=(int)Math.sqrt(currIndexVal);
            pq.offer(currIndexVal);
            j++;
        }
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
}