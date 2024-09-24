class Solution {
    public int majorityElement(int[] arr) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Integer ele:map.keySet()){
            if(map.get(ele)>arr.length/2){
                return ele;
            }
        }
        return -1;
    }
}