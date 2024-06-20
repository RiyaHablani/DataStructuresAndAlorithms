class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        
        pq.addAll(map.keySet());
        
        int[] result = new int[barcodes.length];
        
        int i=0;
        
        while(!pq.isEmpty()) {
            int key = pq.poll();
            int val = map.get(key);
            
            while(val>0) {
                result[i] = key;
                val--;
                i= i+ 2;
                
                if(i>= result.length) {
                 i = 1;   
                }
            }
        }
        
        return result;
    }
}