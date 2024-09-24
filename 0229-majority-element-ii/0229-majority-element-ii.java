class Solution {
    public List<Integer> majorityElement(int[] arr) {
        HashMap<Integer,Integer> map= new HashMap<>();
        ArrayList<Integer> list= new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Integer ele:map.keySet()){
            if(map.get(ele)>arr.length/3){
                list.add(ele);
            }
        }
        return list;
    }
}