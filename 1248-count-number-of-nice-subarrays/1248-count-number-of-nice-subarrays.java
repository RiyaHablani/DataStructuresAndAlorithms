class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0,subArray=0;
        map.put(0,1);
        for(int right=0;right<nums.length;right++){
            if(nums[right]%2!=0){
                count++;
            }
            if(map.containsKey(count-k)){
                subArray+=map.get(count-k);
            }
            map.put(count,map.getOrDefault(count,0)+1);
        }
        return subArray;
    }
}