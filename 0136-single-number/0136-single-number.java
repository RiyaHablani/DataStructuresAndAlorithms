class Solution {
    public int singleNumber(int[] arr) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
        }
        for(Integer ele:map.keySet()){
            if(map.get(ele)==1){
                return ele;
            }
        }
        return -1;
    }
}
